package com.ifba.proj_inov.core.entitites;

import com.ifba.proj_inov.core.entitites.enums.SolicitacaoStatusEnum;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.List;


@Entity
@DiscriminatorValue("SolicitacaoRemocaoArvoreCaida")
public class SolicitacaoRemocaoArvoreCaida extends Solicitacao {

    @Column(name = "bairro", nullable = false)
    private String bairro;

    @Column(name = "nome_rua", nullable = false)
    private String nomeRua;

    public SolicitacaoRemocaoArvoreCaida() {
    }

    public SolicitacaoRemocaoArvoreCaida(String bairro, String nomeRua) {
        this.bairro = bairro;
        this.nomeRua = nomeRua;
    }

    public SolicitacaoRemocaoArvoreCaida(Long id, String descricao, String dataCriada, String dataConcluida, SolicitacaoStatusEnum status, Usuario solicitante, String comentarios, List<Double> notas, String bairro, String nomeRua) {
        super(id, descricao, dataCriada, dataConcluida, status, solicitante, comentarios, notas);
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
