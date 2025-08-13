package com.ifba.proj_inov.api.controller;

import com.ifba.proj_inov.api.dto.PageableDto;
import com.ifba.proj_inov.api.dto.SolicitacaoEnterroAberturaCovaCreateDto;
import com.ifba.proj_inov.api.dto.SolicitacaoEnterroAberturaCovaResponseDto;
import com.ifba.proj_inov.api.dto.SolicitacaoEnterroAberturaCovaUpdateDto;
import com.ifba.proj_inov.api.mapper.PageableMapper;
import com.ifba.proj_inov.core.repository.projection.SolicitacaoEnterroAberturaCovaProjection;
import com.ifba.proj_inov.core.service.SolicitacaoEnterroAberturaCovaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/solicitacao-enterro-abertura-cova")
public class SolicitacaoEnterroAberturaCovaController {

    private final SolicitacaoEnterroAberturaCovaService service;

    @Autowired
    public SolicitacaoEnterroAberturaCovaController(SolicitacaoEnterroAberturaCovaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SolicitacaoEnterroAberturaCovaResponseDto> salvar(@Valid @RequestBody SolicitacaoEnterroAberturaCovaCreateDto createDto) {
        SolicitacaoEnterroAberturaCovaResponseDto solicitacao = service.salvar(createDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(solicitacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolicitacaoEnterroAberturaCovaResponseDto> getById(@PathVariable Long id) {
        SolicitacaoEnterroAberturaCovaResponseDto solicitacao = service.getById(id);
        return ResponseEntity.ok(solicitacao);
    }

    @GetMapping
    public ResponseEntity<PageableDto> getAllSolicitacoes(Pageable pageable) {
        Page<SolicitacaoEnterroAberturaCovaProjection> solicitacoes = service.getAll(pageable);
        return ResponseEntity.ok(PageableMapper.toDto(solicitacoes));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<SolicitacaoEnterroAberturaCovaResponseDto> update(@RequestBody SolicitacaoEnterroAberturaCovaUpdateDto dto, @PathVariable Long id) {
        SolicitacaoEnterroAberturaCovaResponseDto solicitacao = service.update(dto, id);
        return ResponseEntity.ok(solicitacao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
