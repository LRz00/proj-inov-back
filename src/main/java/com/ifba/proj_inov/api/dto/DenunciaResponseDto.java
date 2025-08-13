package com.ifba.proj_inov.api.dto;

import com.ifba.proj_inov.core.entitites.Usuario;
import com.ifba.proj_inov.core.entitites.enums.DenunciaEnum;
import com.ifba.proj_inov.core.entitites.enums.PrioridadeEnum;
import com.ifba.proj_inov.core.entitites.enums.SolicitacaoStatusEnum;
import jakarta.validation.constraints.NotBlank;

public class DenunciaResponseDto {

    private Long id;
    private String descricao;
    private String dataCriada;
    private SolicitacaoStatusEnum status;
    private Usuario solicitante;
    private String comentarios;
    private PrioridadeEnum prioridade;
    private DenunciaEnum denuncia;
    private String dataConcluida;

    public DenunciaResponseDto() {
    }

    public DenunciaResponseDto(Long id, String descricao, String dataCriada, SolicitacaoStatusEnum status, Usuario solicitante, String comentarios, PrioridadeEnum prioridade, DenunciaEnum denuncia, String dataConcluida) {
        this.id = id;
        this.descricao = descricao;
        this.dataCriada = dataCriada;
        this.status = status;
        this.solicitante = solicitante;
        this.comentarios = comentarios;
        this.prioridade = prioridade;
        this.denuncia = denuncia;
        this.dataConcluida = dataConcluida;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
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

    public String getDataConcluida() {
        return dataConcluida;
    }

    public void setDataConcluida(String dataConcluida) {
        this.dataConcluida = dataConcluida;
    }
}
