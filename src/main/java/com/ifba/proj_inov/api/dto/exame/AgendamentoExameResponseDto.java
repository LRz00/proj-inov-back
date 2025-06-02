package com.ifba.proj_inov.api.dto.exame;

import com.ifba.proj_inov.Paciente.dto.PacienteGetResponseDto;
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
    private Long id;
    private PacienteGetResponseDto paciente;
    private ExameDto exame;
    private LocalDateTime dataHora;
    private String localColeta;
    private String observacoes;
    private StatusAgendamento status;
    private LocalDateTime dataCriacao;
}
