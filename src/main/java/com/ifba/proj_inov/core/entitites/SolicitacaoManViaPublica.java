package com.ifba.proj_inov.core.entitites;

import com.ifba.proj_inov.core.entitites.enums.SolicitacaoStatusEnum;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
public class SolicitacaoManViaPublica extends Solicitacao{

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "nome_rua")
    private String nomeRua;

    public SolicitacaoManViaPublica() {
    }

    public SolicitacaoManViaPublica(String bairro, String nomeRua) {
        this.bairro = bairro;
        this.nomeRua = nomeRua;
    }

    public SolicitacaoManViaPublica(Long id, String descricao, String dataCriada, SolicitacaoStatusEnum status, Usuario solicitante, String comentarios, String bairro, String nomeRua) {
        super(id, descricao, dataCriada, status, solicitante, comentarios);
        this.bairro = bairro;
        this.nomeRua = nomeRua;
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
