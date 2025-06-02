package com.ifba.proj_inov.core.repository;

import com.ifba.proj_inov.core.entities.Agendamento;
import com.ifba.proj_inov.core.entities.enums.StatusAgendamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    List<Agendamento> findByPacienteId(Long pacienteId);
    List<Agendamento> findByDataHoraBetween(LocalDateTime inicio, LocalDateTime fim);
    List<Agendamento> findByStatus(StatusAgendamento status);
}
