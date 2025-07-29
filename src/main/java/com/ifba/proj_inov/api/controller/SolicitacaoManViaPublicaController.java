package com.ifba.proj_inov.api.controller;

import com.ifba.proj_inov.api.dto.*;
import com.ifba.proj_inov.api.mapper.PageableMapper;
import com.ifba.proj_inov.api.mapper.SolicitacaoManViaPublicaMapper;
import com.ifba.proj_inov.core.entitites.Solicitacao;
import com.ifba.proj_inov.core.entitites.SolicitacaoManIluminacaoPublica;
import com.ifba.proj_inov.core.entitites.SolicitacaoManViaPublica;
import com.ifba.proj_inov.core.repository.SolicitacaoManViaPublicaRepository;
import com.ifba.proj_inov.core.repository.projection.SolicitacaoManViaPublicaProjection;
import com.ifba.proj_inov.core.service.SolicitacaoManViaPublicaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/solicitacao-man-via-publica")
public class SolicitacaoManViaPublicaController {

    private final SolicitacaoManViaPublicaService service;
    private final SolicitacaoManViaPublicaRepository repository;

    @Autowired
    public SolicitacaoManViaPublicaController(SolicitacaoManViaPublicaService service, SolicitacaoManViaPublicaRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<SolicitacaoManViaPublicaResponseDto> salvar(@Valid @RequestBody SolicitacaoManViaPublicaCreateDto createDto) {
        SolicitacaoManViaPublicaResponseDto solicitacao = service.salvar(createDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(solicitacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolicitacaoManViaPublicaResponseDto> getById(@PathVariable Long id) {
        SolicitacaoManViaPublicaResponseDto solicitacao = service.getById(id);
        return ResponseEntity.ok(solicitacao);
    }

    @GetMapping
    public ResponseEntity<PageableDto> getAllSolicitacoes(Pageable pageable) {
        Page<SolicitacaoManViaPublicaProjection> solicitacoes = service.getAll(pageable);
        return ResponseEntity.ok(PageableMapper.toDto(solicitacoes));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<SolicitacaoManViaPublicaResponseDto> update(@RequestBody SolicitacaoManViaPublicaUpdateDto dto, @PathVariable Long id) {
        SolicitacaoManViaPublicaResponseDto solicitacao = service.update(dto, id);
        return ResponseEntity.ok(solicitacao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/avaliar")
    public ResponseEntity<SolicitacaoManViaPublicaResponseDto> avaliarSolicitacao(
            @PathVariable Long id,
            @RequestParam Double nota) {

        return repository.findById(id)
                .map(solicitacao -> {
                    solicitacao.adicionarNota(nota);
                    SolicitacaoManViaPublica solicitacaoAtualizada = repository.save(solicitacao);

                    SolicitacaoManViaPublicaResponseDto responseDto = service.getSolicitacaoManViaPublicaResponseDto(solicitacaoAtualizada);
                    return ResponseEntity.ok(responseDto);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/media")
    public ResponseEntity<Double> obterMediaAvaliacoes() {
        Double media = service.calcularMedia();
        return ResponseEntity.ok(media);
    }

}
