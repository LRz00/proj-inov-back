package com.ifba.proj_inov.core.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

@Entity
@Data
@Builder
@Table(name="Paciente")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Paciente  extends Pessoa implements Serializable {

    @Column(name = "numeroSus", nullable = false)
    private String numeroSus;

    @Column(name = "numeroNis", nullable = false)
    private String numeroNis;

    @Column(name = "nomeDaMae", nullable = false)
    private String nomeDaMae;

    @Column(name = "altura", nullable = false)
    private Double altura;

    @Column(name = "alergias", nullable = false)
    private String alergias;

    @Column(name = "medicamentosUsados", nullable = false)
    private String medicamentosUsados;

    @Column(name = "doencaCronicas", nullable = false)
    private String doencaCronicas;

}
