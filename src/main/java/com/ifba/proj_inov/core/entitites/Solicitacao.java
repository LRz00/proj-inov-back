package com.ifba.proj_inov.core.entitites;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ifba.proj_inov.core.entitites.enums.SolicitacaoStatusEnum;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "SOLICITACAO")
public class Solicitacao {

    public Solicitacao() {
    }

    public Solicitacao(Long id, String descricao, String dataCriada, String dataConcluida, SolicitacaoStatusEnum status, Usuario solicitante, String comentarios, List<Double> notas) {
        this.id = id;
        this.descricao = descricao;
        this.dataCriada = dataCriada;
        this.dataConcluida = dataConcluida;
        this.status = status;
        this.solicitante = solicitante;
        this.comentarios = comentarios;
        this.notas = notas;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "dataCriada", nullable = false)
    private String dataCriada;

    @Column(name = "dataConcluida")
    private String dataConcluida;

    @Column(name = "status", nullable = false)
    private SolicitacaoStatusEnum status;

    @ManyToOne
    @JoinColumn(name = "solicitante", nullable = false)
    private Usuario solicitante;

    @Column(name = "comentarios")
    private String comentarios;

    @ElementCollection
    private List<Double> notas = new ArrayList<>();

    public void adicionarNota(Double nota) {
        if (nota != null && nota >= 0 && nota <= 5) {
            this.notas.add(nota);
        }
    }

    public Double calcularMedia() {
        if (notas.isEmpty()) {
            return 0.0;
        }

        double soma = 0.0;
        for (Double nota : notas) {
            soma += nota;
        }

        return soma / notas.size();
    }

    public int getQuantidadeAvaliacoes() {
        return notas.size();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataCriada() {
        return dataCriada;
    }

    public void setDataCriada(String dataCriada) {
        this.dataCriada = dataCriada;
    }

    public SolicitacaoStatusEnum getStatus() {
        return status;
    }

    public void setStatus(SolicitacaoStatusEnum status) {
        this.status = status;
    }

    public Usuario getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Usuario solicitante) {
        this.solicitante = solicitante;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public List<Double> getNotas() {
        return notas;
    }

    public void setNotas(List<Double> notas) {
        this.notas = notas;
    }

    public String getDataConcluida() {
        return dataConcluida;
    }

    public void setDataConcluida(String dataConcluida) {
        this.dataConcluida = dataConcluida;
    }
}
