package com.ifba.proj_inov.api.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioCreateDto {

    @NotBlank
    @Size(min = 4, max = 15)
    private String nome;
    @NotBlank
    @Size(min = 1, max = 1)
    private String sexo;
    @NotBlank
    @CPF
    @Size(min = 11, max = 11)
    private String cpf;
    @NotBlank
    @Email(message = "formato do e-mail está invalido", regexp = "^[a-z0-9.+-]+@[a-z0-9.-]+\\.[a-z]{2,}$")
    private String email;
    @NotBlank
    private String senha;
}
