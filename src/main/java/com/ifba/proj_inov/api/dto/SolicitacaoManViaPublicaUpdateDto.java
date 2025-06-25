package com.ifba.proj_inov.api.dto;

import com.ifba.proj_inov.core.entitites.enums.SolicitacaoStatusEnum;

public class SolicitacaoManViaPublicaUpdateDto {

    private String descricao;
    private String comentarios;
    private String bairro;
    private String nomeRua;
    private String status;

    public SolicitacaoManViaPublicaUpdateDto(String descricao, String comentarios, String bairro, String nomeRua, String status) {
        this.descricao = descricao;
        this.comentarios = comentarios;
        this.bairro = bairro;
        this.nomeRua = nomeRua;
        this.status = status;
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

    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
