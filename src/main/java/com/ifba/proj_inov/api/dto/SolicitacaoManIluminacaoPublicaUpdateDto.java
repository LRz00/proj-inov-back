package com.ifba.proj_inov.api.dto;

import com.ifba.proj_inov.core.entitites.enums.PrioridadeEnum;
import com.ifba.proj_inov.core.entitites.enums.SolicitacaoStatusEnum;

public class SolicitacaoManIluminacaoPublicaUpdateDto {

    private String descricao;
    private String comentarios;
    private String bairro;
    private String nomeRua;
    private PrioridadeEnum prioridade;
    private String dataConcluida;
    private SolicitacaoStatusEnum status;

    public SolicitacaoManIluminacaoPublicaUpdateDto(String descricao, String comentarios, String bairro, String nomeRua, PrioridadeEnum prioridade, String dataConcluida, SolicitacaoStatusEnum status) {
        this.descricao = descricao;
        this.comentarios = comentarios;
        this.bairro = bairro;
        this.nomeRua = nomeRua;
        this.prioridade = prioridade;
        this.dataConcluida = dataConcluida;
        this.status = status;
    }

    public SolicitacaoManIluminacaoPublicaUpdateDto() {
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

    public void setStatus(SolicitacaoStatusEnum status) {
        this.status = status;
    }
}
