package com.example.demo.service;

import java.time.LocalDateTime;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.LoginRequestDTO;
import com.example.demo.DTO.LoginResponseDTO;
import com.example.demo.DTO.RegisterRequestDTO;
import com.example.demo.DTO.ResetarSenhaRequestDTO;
import com.example.demo.entity.Usuario;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.security.JwtService;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;
    private final JwtService jwtService;

    public AuthService(
            UsuarioRepository usuarioRepository,
            PasswordEncoder passwordEncoder,
            EmailService emailService,
            JwtService jwtService) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
        this.jwtService = jwtService;
    }

    // CADASTRO
    // =========================
    public void registrar(RegisterRequestDTO dto) {
        String email = dto.getEmail().trim().toLowerCase();

        if (usuarioRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Email já cadastrado");
        }

        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome().trim());
        usuario.setEmail(email);
        usuario.setSenha(passwordEncoder.encode(dto.getSenha()));

        usuarioRepository.save(usuario);
    }

    // LOGIN
    // =========================
    public LoginResponseDTO login(LoginRequestDTO dto) {
        String email = dto.getEmail().trim().toLowerCase();

        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Credenciais inválidas"));

        if (!passwordEncoder.matches(dto.getSenha(), usuario.getSenha())) {
            throw new IllegalArgumentException("Credenciais inválidas");
        }

        String token = jwtService.gerarToken(usuario.getEmail());
        return new LoginResponseDTO(token);
    }

    // RECUPERAÇÃO DE SENHA
    // =========================

    // Passo 1: enviar código
    public void forgotPassword(String email) {
        String emailFormatado = email.trim().toLowerCase();

        Usuario usuario = usuarioRepository.findByEmail(emailFormatado)
                .orElseThrow(() -> new IllegalArgumentException("Email não encontrado"));

        String codigo = String.valueOf((int) (Math.random() * 900000) + 100000);

        usuario.setCodigoRecuperacao(codigo);
        usuario.setValidadeCodigo(LocalDateTime.now().plusMinutes(10));

        usuarioRepository.save(usuario);
        emailService.enviarCodigo(emailFormatado, codigo);
    }

    // Passo 2: redefinir senha
    public void resetPassword(ResetarSenhaRequestDTO dto) {
        String email = dto.getEmail().trim().toLowerCase();
        String codigo = dto.getCodigo().trim();

        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        if (usuario.getCodigoRecuperacao() == null ||
            !codigo.equals(usuario.getCodigoRecuperacao())) {
            throw new IllegalArgumentException("Código inválido");
        }

        if (usuario.getValidadeCodigo() == null ||
            usuario.getValidadeCodigo().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Código expirado");
        }

        usuario.setSenha(passwordEncoder.encode(dto.getNovaSenha()));
        usuario.setCodigoRecuperacao(null);
        usuario.setValidadeCodigo(null);

        usuarioRepository.save(usuario);
    }
}