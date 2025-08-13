package com.ifba.proj_inov.api.dto;

import com.ifba.proj_inov.core.entitites.Usuario;
import com.ifba.proj_inov.core.entitites.enums.SolicitacaoStatusEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class SolicitacaoCapinacaoCreateDto {

    @NotBlank
    private String descricao;

    @NotBlank
    private String dataCriada;

    private SolicitacaoStatusEnum status;

    @NotNull
    private Usuario solicitante;

    @NotBlank
    private String bairro;

    @NotBlank
    private String nomeRua;

    public SolicitacaoCapinacaoCreateDto() {
    }

    public SolicitacaoCapinacaoCreateDto(String descricao, String dataCriada, SolicitacaoStatusEnum status, Usuario solicitante, String bairro, String nomeRua) {
        this.descricao = descricao;
        this.dataCriada = dataCriada;
        this.status = status;
        this.solicitante = solicitante;
        this.bairro = bairro;
        this.nomeRua = nomeRua;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataCriada() {
        return dataCriada;
    }

    public void setDataCriada(String dataCriada) {
        this.dataCriada = dataCriada;
    }

    public SolicitacaoStatusEnum getStatus() {
        return status;
    }

    public void setStatus(SolicitacaoStatusEnum status) {
        this.status = status;
    }

    public Usuario getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Usuario solicitante) {
        this.solicitante = solicitante;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNomeRua() {
        return nomeRua;
    }

    public void setNomeRua(String nomeRua) {
        this.nomeRua = nomeRua;
    }
}
