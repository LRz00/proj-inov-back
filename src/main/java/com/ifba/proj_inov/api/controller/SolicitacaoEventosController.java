package com.ifba.proj_inov.api.controller;

import com.ifba.proj_inov.api.dto.PageableDto;
import com.ifba.proj_inov.api.dto.SolicitacaoEventosCreateDto;
import com.ifba.proj_inov.api.dto.SolicitacaoEventosResponseDto;
import com.ifba.proj_inov.api.dto.SolicitacaoEventosUpdateDto;
import com.ifba.proj_inov.api.mapper.PageableMapper;
import com.ifba.proj_inov.core.repository.projection.SolicitacaoEventosProjection;
import com.ifba.proj_inov.core.service.SolicitacaoEventosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/solicitacao-eventos")
public class SolicitacaoEventosController {
    private final SolicitacaoEventosService service;

    @Autowired
    public SolicitacaoEventosController(SolicitacaoEventosService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SolicitacaoEventosResponseDto> salvar(@Valid @RequestBody SolicitacaoEventosCreateDto createDto) {
        SolicitacaoEventosResponseDto solicitacao = service.salvar(createDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(solicitacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolicitacaoEventosResponseDto> getById(@PathVariable Long id) {
        SolicitacaoEventosResponseDto solicitacao = service.getById(id);
        return ResponseEntity.ok(solicitacao);
    }

    @GetMapping
    public ResponseEntity<PageableDto> getAllSolicitacoes(Pageable pageable) {
        Page<SolicitacaoEventosProjection> solicitacoes = service.getAll(pageable);
        return ResponseEntity.ok(PageableMapper.toDto(solicitacoes));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<SolicitacaoEventosResponseDto> update(@RequestBody SolicitacaoEventosUpdateDto dto, @PathVariable Long id) {
        SolicitacaoEventosResponseDto solicitacao = service.update(dto, id);
        return ResponseEntity.ok(solicitacao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

