package com.ifba.proj_inov.api.dto;

import com.ifba.proj_inov.core.entitites.Usuario;
import com.ifba.proj_inov.core.entitites.enums.SolicitacaoStatusEnum;

public class SolicitacaoEnterroAberturaCovaResponseDto {
    private Long id;
    private String nomeRua;
    private String bairro;
    private String numCasa;
    private String descricao;
    private SolicitacaoStatusEnum status;
    private Usuario solicitante;

    public SolicitacaoEnterroAberturaCovaResponseDto() {
    }

    public SolicitacaoEnterroAberturaCovaResponseDto(Long id, String nomeRua, String bairro, String numCasa, String descricao, SolicitacaoStatusEnum status, Usuario solicitante) {
        this.id = id;
        this.nomeRua = nomeRua;
        this.bairro = bairro;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
