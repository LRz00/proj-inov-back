package com.ifba.proj_inov.api.controller;

import com.ifba.proj_inov.api.dto.*;
import com.ifba.proj_inov.api.mapper.PageableMapper;
import com.ifba.proj_inov.core.entitites.SolicitacaoEventos;
import com.ifba.proj_inov.core.repository.SolicitacaoEventosRepository;
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
    private final SolicitacaoEventosRepository repository;

    @Autowired
    public SolicitacaoEventosController(SolicitacaoEventosService service, SolicitacaoEventosRepository repository) {
        this.service = service;
        this.repository = repository;
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

    @PostMapping("/{id}/avaliar")
    public ResponseEntity<SolicitacaoEventosResponseDto> avaliarSolicitacao(
            @PathVariable Long id,
            @RequestParam Double nota) {

        return repository.findById(id)
                .map(solicitacao -> {
                    solicitacao.adicionarNota(nota);
                    SolicitacaoEventos solicitacaoAtualizada = repository.save(solicitacao);

                    SolicitacaoEventosResponseDto responseDto = service.getSolicitacaoEventosResponseDto(solicitacaoAtualizada);
                    return ResponseEntity.ok(responseDto);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/media")
    public ResponseEntity<Double> obterMediaAvaliacoes(@PathVariable Long id) {
        return repository.findById(id)
                .map(solicitacao -> ResponseEntity.ok(solicitacao.calcularMedia()))
                .orElse(ResponseEntity.notFound().build());
    }
}

