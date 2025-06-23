package com.ifba.proj_inov.api.dto;

import com.ifba.proj_inov.core.entitites.enums.UsuarioEnum;

public class UsuariosResponseDto {

    public UsuariosResponseDto() {
    }

    public UsuariosResponseDto(Long id, String nome, String cpf, String email, String senha, UsuarioEnum perfil) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.perfil = perfil;
    }

    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private UsuarioEnum perfil;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
