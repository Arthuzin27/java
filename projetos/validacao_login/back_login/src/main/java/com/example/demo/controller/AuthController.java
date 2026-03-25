package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.DTO.*;
import com.example.demo.service.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // CADASTRO
    // =========================
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterRequestDTO dto) {
        authService.registrar(dto);
        return ResponseEntity.status(201).body("Usuário cadastrado com sucesso");
    }

    // LOGIN
    // =========================
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login( @RequestBody @Valid LoginRequestDTO dto) {
        return ResponseEntity.ok(authService.login(dto));
    }

    // RECUPERAÇÃO DE SENHA
    // =========================

    // Passo 1: enviar código
    @PostMapping("/forgot-password") public ResponseEntity<?> forgotPassword(@RequestBody @Valid RecuperarSenhaRequestDTO dto) {
        authService.forgotPassword(dto.getEmail());
        return ResponseEntity.ok("Código enviado para o e-mail");
    }

    // Passo 2: redefinir senha
    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody @Valid ResetarSenhaRequestDTO dto) {
        authService.resetPassword(dto);
        return ResponseEntity.ok("Senha redefinida com sucesso");
    }
}