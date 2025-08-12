package com.ifba.proj_inov.api.dto;

import com.ifba.proj_inov.core.entitites.enums.DenunciaEnum;
import com.ifba.proj_inov.core.entitites.enums.PrioridadeEnum;
import com.ifba.proj_inov.core.entitites.enums.SolicitacaoStatusEnum;

public class DenunciaUpdateDto {

    private String descricao;
    private String comentarios;
    private String dataConcluida;
    private PrioridadeEnum prioridade;
    private DenunciaEnum denuncia;
    private SolicitacaoStatusEnum status;

    public DenunciaUpdateDto(String descricao, String comentarios, String dataConcluida, PrioridadeEnum prioridade, DenunciaEnum denuncia, SolicitacaoStatusEnum status) {
        this.descricao = descricao;
        this.comentarios = comentarios;
        this.dataConcluida = dataConcluida;
        this.prioridade = prioridade;
        this.denuncia = denuncia;
        this.status = status;
    }

    public DenunciaUpdateDto() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getDataConcluida() {
        return dataConcluida;
    }

    public void setDataConcluida(String dataConcluida) {
        this.dataConcluida = dataConcluida;
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

    public SolicitacaoStatusEnum getStatus() {
        return status;
    }

    public void setStatus(SolicitacaoStatusEnum status) {
        this.status = status;
    }
}
