package com.ifba.proj_inov.Paciente.service;

import com.ifba.proj_inov.Paciente.entity.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface PacienteIService {

    Page<Paciente> findAll(Pageable pageable);

    List<Paciente> findByNomeCompleto(String nomeCompleto);

    Paciente findById(Long id);

    Paciente save(Paciente paciente);

    void update(Paciente paciente);

    Map<String, String> delete(Long id);


}
