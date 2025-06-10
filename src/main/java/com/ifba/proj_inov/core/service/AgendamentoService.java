package com.ifba.proj_inov.core.service;

import com.ifba.proj_inov.api.dto.PacienteGetResponseDto;
import com.ifba.proj_inov.core.entities.Paciente;
import com.ifba.proj_inov.api.infrastructure.mapper.ObjectMapperUtil;
import com.ifba.proj_inov.api.dto.exame.AgendamentoExameRequestDto;
import com.ifba.proj_inov.api.dto.exame.AgendamentoExameResponseDto;
import com.ifba.proj_inov.api.dto.exame.ExameDto;
import com.ifba.proj_inov.core.entities.Agendamento;
import com.ifba.proj_inov.core.entities.Exame;
import com.ifba.proj_inov.core.entities.enums.StatusAgendamento;
import com.ifba.proj_inov.core.repository.AgendamentoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgendamentoService {
    private final AgendamentoRepository agendamentoRepository;
    private final PacienteService pacienteService;
    private final ExameService exameService;
    private final ObjectMapperUtil objectMapperUtil;

    public AgendamentoService(AgendamentoRepository agendamentoRepository, PacienteService pacienteService, ExameService exameService, ObjectMapperUtil objectMapperUtil) {
        this.agendamentoRepository = agendamentoRepository;
        this.pacienteService = pacienteService;
        this.exameService = exameService;
        this.objectMapperUtil = objectMapperUtil;
    }

    @Transactional
    public AgendamentoExameResponseDto agendarExame(AgendamentoExameRequestDto requestDto) {
        Paciente paciente = pacienteService.findById(requestDto.getPacienteId());
        Exame exame = exameService.findById(requestDto.getExameId());

        Agendamento agendamento = new Agendamento(
                paciente,
                exame,
                requestDto.getDataHora(),
                requestDto.getLocalColeta(),
                requestDto.getObservacoes(),
                StatusAgendamento.AGENDADO,
                LocalDateTime.now()
        );

        agendamento = agendamentoRepository.save(agendamento);
        return convertToDto(agendamento);
    }

    public List<AgendamentoExameResponseDto> listarAgendamentosPorPaciente(Long pacienteId) {
        return agendamentoRepository.findByPacienteId(pacienteId)
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private AgendamentoExameResponseDto convertToDto(Agendamento agendamento) {
        AgendamentoExameResponseDto dto = objectMapperUtil.map(agendamento, AgendamentoExameResponseDto.class);
        dto.setPaciente(objectMapperUtil.map(agendamento.getPaciente(), PacienteGetResponseDto.class));
        dto.setExame(objectMapperUtil.map(agendamento.getExame(), ExameDto.class));
        return dto;
    }
}
