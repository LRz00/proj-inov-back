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
@AllArgsConstructor
@NoArgsConstructor
public class AgendamentoExameRequestDto {
    @NotNull(message = "ID do paciente é obrigatório")
    private Long pacienteId;

    @NotNull(message = "ID do exame é obrigatório")
    private Long exameId;

    @FutureOrPresent(message = "Data deve ser presente ou futura")
    private LocalDateTime dataHora;

    @NotBlank(message = "Local de coleta é obrigatório")
    private String localColeta;

    private String observacoes;
}
