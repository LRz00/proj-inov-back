package com.ifba.proj_inov.api.dto.exame;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
public class AgendamentoExameRequestDto {

    public AgendamentoExameRequestDto() {
    }

    public AgendamentoExameRequestDto(Long pacienteId, Long exameId, LocalDateTime dataHora, String localColeta, String observacoes) {
        this.pacienteId = pacienteId;
        this.exameId = exameId;
        this.dataHora = dataHora;
        this.localColeta = localColeta;
        this.observacoes = observacoes;
    }

    @NotNull(message = "ID do paciente é obrigatório")
    private Long pacienteId;

    @NotNull(message = "ID do exame é obrigatório")
    private Long exameId;

    @FutureOrPresent(message = "Data deve ser presente ou futura")
    private LocalDateTime dataHora;

    @NotBlank(message = "Local de coleta é obrigatório")
    private String localColeta;

    private String observacoes;

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }

    public Long getExameId() {
        return exameId;
    }

    public void setExameId(Long exameId) {
        this.exameId = exameId;
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
}
