package com.ifba.proj_inov.core.entitites;

import com.ifba.proj_inov.core.entitites.enums.SolicitacaoStatusEnum;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import java.util.List;

@Entity
@DiscriminatorValue("SolicitacaoEnterroAberturaCova")
public class SolicitacaoEnterroAberturaCova extends Solicitacao {

    @Column(name = "nome_rua", nullable = false)
    private String nomeRua;

    @Column(name = "bairro", nullable = false)
    private String bairro;

    @Column(name = "numero_Casa")
    private String numCasa;

    public SolicitacaoEnterroAberturaCova() {
    }

    public SolicitacaoEnterroAberturaCova(String nomeRua, String bairro, String numCasa) {
        this.nomeRua = nomeRua;
        this.bairro = bairro;
        this.numCasa = numCasa;
    }

    public SolicitacaoEnterroAberturaCova(Long id, String descricao, String dataCriada, String dataConcluida,
                                      SolicitacaoStatusEnum status, Usuario solicitante,
                                      String comentarios, List<Double> notas,
                                      String nomeRua, String bairro, String numCasa) {
    super(id, descricao, dataCriada, dataConcluida, status, solicitante, comentarios, notas);
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
