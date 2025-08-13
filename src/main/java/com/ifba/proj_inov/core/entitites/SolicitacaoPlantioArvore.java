package com.ifba.proj_inov.core.entitites;

import com.ifba.proj_inov.core.entitites.enums.SolicitacaoStatusEnum;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;

import java.util.List;

@Entity
@DiscriminatorValue("SolicitacaoPlantioArvore")
public class SolicitacaoPlantioArvore extends Solicitacao {

    @Column(name = "nome_rua", nullable = false)
    private String nomeRua;

    @Column(name = "bairro", nullable = false)
    private String bairro;

    @Column(name = "nome_Arvore")
    private String nomeArvore;

    @Column(name = "numero_Casa")
    private String numCasa;

    public SolicitacaoPlantioArvore() {

    }

    public SolicitacaoPlantioArvore(String nomeRua, String bairro, String nomeArvore, String numCasa) {
        this.nomeRua = nomeRua;
        this.bairro = bairro;
        this.nomeArvore = nomeArvore;
        this.numCasa = numCasa;
    }

    public SolicitacaoPlantioArvore(Long id, String descricao, String dataCriada, String dataConcluida, SolicitacaoStatusEnum status, Usuario solicitante, String comentarios, List<Double> notas, String nomeRua, String bairro, String nomeArvore, String numCasa) {
        super(id, descricao, dataCriada, dataConcluida, status, solicitante, comentarios, notas);
        this.nomeRua = nomeRua;
        this.bairro = bairro;
        this.nomeArvore = nomeArvore;
        this.numCasa = numCasa;
    }

    public void setNomeRua(String nomeRua) {
        this.nomeRua = nomeRua;
    }

    public String getNomeRua() {
        return nomeRua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNomeArvore() {
        return nomeArvore;
    }

    public void setNomeArvore(String nomeArvore) {
        this.nomeArvore = nomeArvore;
    }

    public String getNumCasa() {
        return numCasa;
    }

    public void setNumCasa(String numCasa) {
        this.numCasa = numCasa;
    }
}
