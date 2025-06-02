package com.ifba.proj_inov.core.repository;

import com.ifba.proj_inov.core.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    List<Paciente> findByNomeCompleto(String nomeCompleto);
}
