package com.ifba.proj_inov.api.dto.exame;

import com.ifba.proj_inov.api.dto.PacienteGetResponseDto;
import com.ifba.proj_inov.core.entities.enums.StatusAgendamento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AgendamentoExameResponseDto {

    public AgendamentoExameResponseDto() {
    }

    public AgendamentoExameResponseDto(Long id, PacienteGetResponseDto paciente, ExameDto exame, LocalDateTime dataHora, String localColeta, String observacoes, StatusAgendamento status, LocalDateTime dataCriacao) {
        this.id = id;
        this.paciente = paciente;
        this.exame = exame;
        this.dataHora = dataHora;
        this.localColeta = localColeta;
        this.observacoes = observacoes;
        this.status = status;
        this.dataCriacao = dataCriacao;
    }

    private Long id;
    private PacienteGetResponseDto paciente;
    private ExameDto exame;
    private LocalDateTime dataHora;
    private String localColeta;
    private String observacoes;
    private StatusAgendamento status;
    private LocalDateTime dataCriacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PacienteGetResponseDto getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteGetResponseDto paciente) {
        this.paciente = paciente;
    }

    public ExameDto getExame() {
        return exame;
    }

    public void setExame(ExameDto exame) {
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
