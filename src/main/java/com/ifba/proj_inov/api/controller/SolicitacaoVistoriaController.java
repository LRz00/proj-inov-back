package com.ifba.proj_inov.api.controller;

import com.ifba.proj_inov.api.dto.PageableDto;
import com.ifba.proj_inov.api.dto.SolicitacaoVistoriaCreateDto;
import com.ifba.proj_inov.api.dto.SolicitacaoVistoriaResponseDto;
import com.ifba.proj_inov.api.dto.SolicitacaoVistoriaUpdateDto;
import com.ifba.proj_inov.api.mapper.PageableMapper;
import com.ifba.proj_inov.core.repository.projection.SolicitacaoVistoriaProjection;
import com.ifba.proj_inov.core.service.SolicitacaoVistoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/solicitacao-vistoria")
public class SolicitacaoVistoriaController {

    private final SolicitacaoVistoriaService service;

    @Autowired
    public SolicitacaoVistoriaController(SolicitacaoVistoriaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SolicitacaoVistoriaResponseDto> salvar(@Valid @RequestBody SolicitacaoVistoriaCreateDto createDto) {
        SolicitacaoVistoriaResponseDto solicitacao = service.salvar(createDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(solicitacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolicitacaoVistoriaResponseDto> getById(@PathVariable Long id) {
        SolicitacaoVistoriaResponseDto solicitacao = service.getById(id);
        return ResponseEntity.ok(solicitacao);
    }

    @GetMapping
    public ResponseEntity<PageableDto> getAllSolicitacoes(Pageable pageable) {
        Page<SolicitacaoVistoriaProjection> solicitacoes = service.getAll(pageable);
        return ResponseEntity.ok(PageableMapper.toDto(solicitacoes));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<SolicitacaoVistoriaResponseDto> update(@RequestBody SolicitacaoVistoriaUpdateDto dto, @PathVariable Long id) {
        SolicitacaoVistoriaResponseDto solicitacao = service.update(dto, id);
        return ResponseEntity.ok(solicitacao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}

