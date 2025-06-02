package com.ifba.proj_inov.core.entities;

import com.ifba.proj_inov.core.entities.enums.StatusAgendamento;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "AgendamentoExame")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Agendamento implements Serializable {

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
}

