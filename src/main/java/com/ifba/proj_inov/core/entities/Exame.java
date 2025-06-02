package com.ifba.proj_inov.core.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Data
@Builder
@Table(name = "Exame")
@AllArgsConstructor
@NoArgsConstructor
public class Exame implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao", columnDefinition = "TEXT")
    private String descricao;

//    @Column(name = "codigoTuss")
//    private String codigoTuss;
//
//    @Column(name = "ativo", nullable = false)
//    private Boolean ativo;
    
}
