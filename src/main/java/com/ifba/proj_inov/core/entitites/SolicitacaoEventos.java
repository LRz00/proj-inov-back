package com.ifba.proj_inov.core.entitites;

import com.ifba.proj_inov.core.entitites.enums.SolicitacaoStatusEnum;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class SolicitacaoEventos extends Solicitacao {

    public SolicitacaoEventos() {
    }

    public SolicitacaoEventos(String bairro, String nomeRua, String local, LocalDateTime dataEvento, String tipoEvento) {
        this.bairro = bairro;
        this.nomeRua = nomeRua;
        this.local = local;
        this.dataEvento = dataEvento;
        this.tipoEvento = tipoEvento;
    }

    public SolicitacaoEventos(Long id, String descricao, String dataCriada, String dataConcluida, SolicitacaoStatusEnum status, Usuario solicitante, String comentarios, List<Double> notas, String bairro, String nomeRua, String local, LocalDateTime dataEvento, String tipoEvento) {
        super(id, descricao, dataCriada, dataConcluida, status, solicitante, comentarios, notas);
        this.bairro = bairro;
        this.nomeRua = nomeRua;
        this.local = local;
        this.dataEvento = dataEvento;
        this.tipoEvento = tipoEvento;
    }

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "nome_rua")
    private String nomeRua;

    @Column(name = "local")
    private String local;

    @Column(name = "data_evento")
    private LocalDateTime dataEvento;

    @Column(name = "tipo_evento")
    private String tipoEvento;


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

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public LocalDateTime getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDateTime dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }
}
