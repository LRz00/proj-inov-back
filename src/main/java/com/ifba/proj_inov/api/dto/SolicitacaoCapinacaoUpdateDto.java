package com.ifba.proj_inov.api.dto;

public class SolicitacaoCapinacaoUpdateDto {

    private String descricao;
    private String comentarios;
    private String bairro;
    private String nomeRua;

    public SolicitacaoCapinacaoUpdateDto(String descricao, String comentarios, String bairro, String nomeRua) {
        this.descricao = descricao;
        this.comentarios = comentarios;
        this.bairro = bairro;
        this.nomeRua = nomeRua;
    }

    public SolicitacaoCapinacaoUpdateDto() {
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
}
