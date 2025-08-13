package com.ifba.proj_inov.api.dto;

import com.ifba.proj_inov.core.entitites.Usuario;
import com.ifba.proj_inov.core.entitites.enums.DenunciaEnum;
import com.ifba.proj_inov.core.entitites.enums.PrioridadeEnum;
import com.ifba.proj_inov.core.entitites.enums.SolicitacaoStatusEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class DenunciaCreateDto {

    @NotBlank
    private String descricao;

    @NotBlank
    private String dataCriada;

    private SolicitacaoStatusEnum status;

    @NotNull
    private Usuario solicitante;

    @NotNull
    private PrioridadeEnum prioridade;

    @NotNull
    private DenunciaEnum denuncia;

    public DenunciaCreateDto() {
    }

    public DenunciaCreateDto(String descricao, String dataCriada, SolicitacaoStatusEnum status, Usuario solicitante, PrioridadeEnum prioridade, DenunciaEnum denuncia) {
        this.descricao = descricao;
        this.dataCriada = dataCriada;
        this.status = status;
        this.solicitante = solicitante;
        this.prioridade = prioridade;
        this.denuncia = denuncia;
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

    public PrioridadeEnum getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(PrioridadeEnum prioridade) {
        this.prioridade = prioridade;
    }

    public DenunciaEnum getDenuncia() {
        return denuncia;
    }

    public void setDenuncia(DenunciaEnum denuncia) {
        this.denuncia = denuncia;
    }
}
