package com.example.demo.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResetarSenhaRequestDTO {

    @NotBlank
    private String email;

    @NotBlank
    private String codigo;

    @NotBlank
    private String novaSenha;
}