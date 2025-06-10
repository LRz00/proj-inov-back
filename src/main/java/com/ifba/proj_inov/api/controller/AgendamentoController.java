package com.ifba.proj_inov.api.controller;

import com.ifba.proj_inov.api.dto.exame.AgendamentoExameRequestDto;
import com.ifba.proj_inov.api.dto.exame.AgendamentoExameResponseDto;
import com.ifba.proj_inov.core.service.AgendamentoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamento-exame")
@CrossOrigin("*")
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    public AgendamentoController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AgendamentoExameResponseDto> agendarExame(
            @RequestBody @Valid AgendamentoExameRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(agendamentoService.agendarExame(requestDto));
    }

    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<List<AgendamentoExameResponseDto>> listarPorPaciente(
            @PathVariable Long pacienteId) {
        return ResponseEntity.ok(agendamentoService.listarAgendamentosPorPaciente(pacienteId));
    }
}
