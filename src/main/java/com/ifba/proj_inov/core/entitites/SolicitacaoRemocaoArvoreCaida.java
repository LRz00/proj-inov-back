package com.ifba.proj_inov.core.entitites;

import com.ifba.proj_inov.core.entitites.enums.SolicitacaoStatusEnum;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;


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

    public SolicitacaoRemocaoArvoreCaida(Long id, String descricao, String dataCriada, SolicitacaoStatusEnum status, Usuario solicitante, String comentarios, String bairro, String nomeRua) {
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
