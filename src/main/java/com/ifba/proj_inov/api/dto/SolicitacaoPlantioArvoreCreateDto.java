package com.ifba.proj_inov.api.dto;

import com.ifba.proj_inov.core.entitites.Usuario;
import com.ifba.proj_inov.core.entitites.enums.SolicitacaoStatusEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class SolicitacaoPlantioArvoreCreateDto {

    @NotBlank
    private String nomeRua;

    @NotBlank
    private String bairro;

    @NotBlank
    private String dataCriada;

    
    private String nomeArvore;

    
    private String numCasa;

    @NotBlank
    private String descricao;


    private SolicitacaoStatusEnum status;

    @NotNull
    private Usuario solicitante;

    public SolicitacaoPlantioArvoreCreateDto() {
    }

    public SolicitacaoPlantioArvoreCreateDto(String nomeRua, String bairro, String nomeArvore, String dataCriada, String numCasa, String descricao, SolicitacaoStatusEnum status, Usuario solicitante) {
        this.nomeRua = nomeRua;
        this.bairro = bairro;
        this.nomeArvore = nomeArvore;
        this.dataCriada = dataCriada;
        this.numCasa = numCasa;
        this.descricao = descricao;
        this.status = status;
        this.solicitante = solicitante;
    }

    public String getNomeRua() {
        return nomeRua;
    }

    public void setNomeRua(String nomeRua) {
        this.nomeRua = nomeRua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNomeArvore() {
        return nomeArvore;
    }

    public void setNomeArvore(String nomeArvore) {
        this.nomeArvore = nomeArvore;
    }

    public String getNumCasa() {
        return numCasa;
    }

    public void setNumCasa(String numCasa) {
        this.numCasa = numCasa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public String getDataCriada() {
        return dataCriada;
    }

    public void setDataCriada(String dataCriada) {
        this.dataCriada = dataCriada;
    }
}
