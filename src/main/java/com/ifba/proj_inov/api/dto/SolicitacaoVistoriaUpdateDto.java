package com.ifba.proj_inov.api.dto;

import com.ifba.proj_inov.core.entitites.enums.SolicitacaoStatusEnum;

public class SolicitacaoVistoriaUpdateDto {

    private String descricao;
    private String nomeRua;
    private String bairro;
    private SolicitacaoStatusEnum status;
    private String comentarios;

    public SolicitacaoVistoriaUpdateDto() {
    }

    public SolicitacaoVistoriaUpdateDto(String descricao, String nomeRua, String bairro, SolicitacaoStatusEnum status, String comentarios) {
        this.descricao = descricao;
        this.nomeRua = nomeRua;
        this.bairro = bairro;
        this.status = status;
        this.comentarios = comentarios;

    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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


    public SolicitacaoStatusEnum getStatus() {
        return status;
    }

    public void setStatus(SolicitacaoStatusEnum status) {
        this.status = status;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
}
