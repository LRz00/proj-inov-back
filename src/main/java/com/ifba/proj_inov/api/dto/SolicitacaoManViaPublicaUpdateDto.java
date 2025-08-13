package com.ifba.proj_inov.api.dto;

import com.ifba.proj_inov.core.entitites.enums.PrioridadeEnum;
import com.ifba.proj_inov.core.entitites.enums.SolicitacaoStatusEnum;

public class SolicitacaoManViaPublicaUpdateDto {

    private String descricao;
    private String comentarios;
    private String bairro;
    private String nomeRua;
    private SolicitacaoStatusEnum status;
    private PrioridadeEnum prioridade;
    private String dataConcluida;

    public SolicitacaoManViaPublicaUpdateDto(String descricao, String comentarios, String bairro, String nomeRua, SolicitacaoStatusEnum status, PrioridadeEnum prioridade, String dataConcluida) {
        this.descricao = descricao;
        this.comentarios = comentarios;
        this.bairro = bairro;
        this.nomeRua = nomeRua;
        this.status = status;
        this.prioridade = prioridade;
        this.dataConcluida = dataConcluida;
    }

    public SolicitacaoManViaPublicaUpdateDto() {
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public void setStatus(SolicitacaoStatusEnum status) {
        this.status = status;
    }

    public PrioridadeEnum getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(PrioridadeEnum prioridade) {
        this.prioridade = prioridade;
    }

    public String getDataConcluida() {
        return dataConcluida;
    }

    public void setDataConcluida(String dataConcluida) {
        this.dataConcluida = dataConcluida;
    }

    public SolicitacaoStatusEnum getStatus() {
        return status;
    }
}
