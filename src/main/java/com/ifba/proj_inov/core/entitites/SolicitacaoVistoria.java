package com.ifba.proj_inov.core.entitites;

import com.ifba.proj_inov.core.entitites.enums.SolicitacaoStatusEnum;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("SolicitacaoVistoria")
public class SolicitacaoVistoria extends Solicitacao {

    @Column(name = "nome_rua", nullable = false)
    private String nomeRua;

    @Column(name = "bairro", nullable = false)
    private String bairro;

    @Column(name = "numero_Casa")
    private String numCasa;

    public SolicitacaoVistoria() {
    }

    public SolicitacaoVistoria(String nomeRua, String bairro, String numCasa) {
        this.nomeRua = nomeRua;
        this.bairro = bairro;
        this.numCasa = numCasa;
    }

    public SolicitacaoVistoria(Long id, String descricao, String dataCriada, SolicitacaoStatusEnum status, Usuario solicitante, String comentarios, String nomeRua, String bairro, String numCasa) {
        super(id, descricao, dataCriada, status, solicitante, comentarios);
        this.nomeRua = nomeRua;
        this.bairro = bairro;
        this.numCasa = numCasa;
    }

    public String getNumCasa() {
        return numCasa;
    }

    public void setNumCasa(String numCasa) {
        this.numCasa = numCasa;
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
