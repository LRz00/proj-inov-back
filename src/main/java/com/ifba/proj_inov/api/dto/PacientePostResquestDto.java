package com.ifba.proj_inov.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacientePostResquestDto {

    @JsonProperty(value = "nomeCompleto")
    @NotNull(message = "O nome é obrigatorio")
    @NotBlank(message = "O campo nome nao pode ser vazio")
    private String nomeCompleto;

    @JsonProperty(value = "cpf")
    @NotNull(message = "O CPF é obrigatorio")
    @NotBlank(message = "O campo CPF nao pode ser vazio")
    private String cpf;

    @JsonProperty(value = "rg")
    @NotNull(message = "O RG é obrigatorio")
    @NotBlank(message = "O campo RG nao pode ser vazio")
    private String rg;

    @JsonProperty(value = "genero")
    @NotNull(message = "Genero é obrigatorio")
    @NotBlank(message = "O campo genero nao pode ser vazio")
    private String genero;

    @JsonProperty(value = "numeroSus")
    @NotNull(message = "O Numero do SUS é obrigatorio")
    @NotBlank(message = "O campo Numero do SUS nao pode ser vazio")
    private String numeroSus;

    @JsonProperty(value = "numeroNis")
    @NotNull(message = "O numero do NIS é obrigatorio")
    @NotBlank(message = "O campo numero do NIS nao pode ser vazio")
    private String numeroNis;

    @JsonProperty(value = "nomeDaMae")
    @NotNull(message = "O nome da mae é obrigatorio")
    @NotBlank(message = "O campo nome da mae nao pode ser vazio")
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
    @NotNull(message = "A cidade é obrigatoria")
    @NotBlank(message = "O campo cidade nao pode ser vazio")
    private String cidade;

    @JsonProperty(value = "estadoCivil")
    @NotNull(message = "O estado civil é obrigatorio")
    @NotBlank(message = "O campo estado civil nao pode ser vazio")
    private String estadoCivil;

    @JsonProperty(value = "idade")
    @NotNull(message = "idade é obrigatorio")
    @NotBlank(message = "O campo idade pode ser vazio")
    private Integer idade;
}
