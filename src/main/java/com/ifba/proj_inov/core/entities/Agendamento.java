package com.ifba.proj_inov.core.entities;

import com.ifba.proj_inov.core.entities.enums.StatusAgendamento;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "AgendamentoExame")
@Builder
public class Agendamento implements Serializable {

    public Agendamento() {
    }

    public Agendamento(Long id, Paciente paciente, Exame exame, LocalDateTime dataHora, String localColeta, String observacoes, StatusAgendamento status, LocalDateTime dataCriacao) {
        this.id = id;
        this.paciente = paciente;
        this.exame = exame;
        this.dataHora = dataHora;
        this.localColeta = localColeta;
        this.observacoes = observacoes;
        this.status = status;
        this.dataCriacao = dataCriacao;
    }

    public Agendamento(Paciente paciente, Exame exame, LocalDateTime dataHora, String localColeta, String observacoes, StatusAgendamento statusAgendamento, LocalDateTime now) {
        this.paciente = paciente;
        this.exame = exame;
        this.dataHora = dataHora;
        this.localColeta = localColeta;
        this.observacoes = observacoes;
        this.status = statusAgendamento;
        this.dataCriacao = now;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "exame_id", nullable = false)
    private Exame exame;

    @Column(name = "dataHora", nullable = false)
    private LocalDateTime dataHora;

    @Column(name = "localColeta", nullable = false)
    private String localColeta;

    @Column(name = "observacoes", columnDefinition = "TEXT")
    private String observacoes;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusAgendamento status;

    @Column(name = "dataCriacao", nullable = false)
    private LocalDateTime dataCriacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Exame getExame() {
        return exame;
    }

    public void setExame(Exame exame) {
        this.exame = exame;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getLocalColeta() {
        return localColeta;
    }

    public void setLocalColeta(String localColeta) {
        this.localColeta = localColeta;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public StatusAgendamento getStatus() {
        return status;
    }

    public void setStatus(StatusAgendamento status) {
        this.status = status;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}

