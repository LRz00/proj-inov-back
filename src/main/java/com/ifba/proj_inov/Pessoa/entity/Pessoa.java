package com.ifba.proj_inov.Pessoa.entity;


import com.ifba.proj_inov.Paciente.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@MappedSuperclass
public class Pessoa extends PersistenceEntity implements Serializable {

    @Column(name = "nomeCompleto", nullable = false)
    private String nomeCompleto;

    @Column(name = "CPF", nullable = false)
    private String cpf;

    @Column(name = "RG", nullable = false)
    private String rg;

    @Column(name = "genero", nullable = false)
    private String genero;

    @Column(name = "dataNascimento", nullable = false)
    private Date dataNascimento;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @Column(name = "cidade", nullable = false)
    private String cidade;

    @Column(name = "estadoCivil", nullable = false)
    private String estadoCivil;

    @Column(name = "idade", nullable = false)
    private Integer idade;

}
