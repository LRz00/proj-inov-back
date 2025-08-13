package com.ifba.proj_inov.core.entitites;

import com.ifba.proj_inov.core.entitites.enums.PrioridadeEnum;
import com.ifba.proj_inov.core.entitites.enums.SolicitacaoStatusEnum;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.List;

@Entity
public class SolicitacaoManViaPublica extends Solicitacao{

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "nome_rua")
    private String nomeRua;

    @Column(name = "prioridade")
    private PrioridadeEnum prioridade;

    public SolicitacaoManViaPublica() {
    }

    public SolicitacaoManViaPublica(String bairro, String nomeRua, PrioridadeEnum prioridade) {
        this.bairro = bairro;
        this.nomeRua = nomeRua;
        this.prioridade = prioridade;
    }

    public SolicitacaoManViaPublica(Long id, String descricao, String dataCriada, String dataConcluida, SolicitacaoStatusEnum status, Usuario solicitante, String comentarios, List<Double> notas, String bairro, String nomeRua, PrioridadeEnum prioridade) {
        super(id, descricao, dataCriada, dataConcluida, status, solicitante, comentarios, notas);
        this.bairro = bairro;
        this.nomeRua = nomeRua;
        this.prioridade = prioridade;
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
}
