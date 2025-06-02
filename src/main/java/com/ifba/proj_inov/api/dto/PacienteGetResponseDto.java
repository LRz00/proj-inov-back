package com.ifba.proj_inov.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacienteGetResponseDto {

    @JsonProperty(value = "nomeCompleto")
    private String nomeCompleto;

    @JsonProperty(value = "cpf")
    private String cpf;

    @JsonProperty(value = "rg")
    private String rg;

    @JsonProperty(value = "genero")
    private String genero;

    @JsonProperty(value = "numeroSus")
    private String numeroSus;

    @JsonProperty(value = "numeroNis")
    private String numeroNis;

    @JsonProperty(value = "nomeDaMae")
    private String nomeDaMae;

    @JsonProperty(value = "altura")
    private Double altura;

    @JsonProperty(value = "alergias")
    private String alergias;

    @JsonProperty(value = "medicamentoUsados")
    private String medicamentosUsados;

    @JsonProperty(value = "doencaCronicas")
    private String doencaCronicas;

    @JsonProperty(value = "telefone")
    private String telefone;

    @JsonProperty(value = "cidade")
    private String cidade;

    @JsonProperty(value = "estadoCivil")
    private String estadoCivil;

    @JsonProperty(value = "idade")
    private Integer idade;

}
