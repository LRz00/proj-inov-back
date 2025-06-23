package com.ifba.proj_inov.api.dto;

import com.ifba.proj_inov.core.entitites.enums.UsuarioEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

public class UsuariosCreateDto {

    public UsuariosCreateDto() {
    }

    public UsuariosCreateDto(String nome, String cpf, String email, String senha, UsuarioEnum perfil) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.perfil = perfil;
    }

    @NotBlank
    @Size(min = 4, max = 15)
    private String nome;
    @NotBlank
    @CPF
    @Size(min = 11, max = 11)
    private String cpf;
    @NotBlank
    @Email(message = "formato do e-mail está invalido", regexp = "^[a-z0-9.+-]+@[a-z0-9.-]+\\.[a-z]{2,}$")
    private String email;
    @NotBlank
    private String senha;
    @NotBlank
    private UsuarioEnum perfil;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public UsuarioEnum getPerfil() {
        return perfil;
    }

    public void setPerfil(UsuarioEnum perfil) {
        this.perfil = perfil;
    }
}
