package com.ifba.proj_inov.api.dto;

public class SolicitacoesUpdateDto {

    private String descricao;
    private String comentarios;

    public SolicitacoesUpdateDto(String descricao, String comentarios) {
        this.descricao = descricao;
        this.comentarios = comentarios;
    }

    public SolicitacoesUpdateDto() {
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
}
