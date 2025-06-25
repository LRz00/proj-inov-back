package com.ifba.proj_inov.api.controller;

import com.ifba.proj_inov.api.dto.PageableDto;
import com.ifba.proj_inov.api.dto.SolicitacaoManIluminacaoPublicaCreateDto;
import com.ifba.proj_inov.api.dto.SolicitacaoManIluminacaoPublicaResponseDto;
import com.ifba.proj_inov.api.dto.SolicitacaoManIluminacaoPublicaUpdateDto;
import com.ifba.proj_inov.api.mapper.PageableMapper;
import com.ifba.proj_inov.core.repository.projection.SolicitacaoManIluminacaoPublicaProjection;
import com.ifba.proj_inov.core.service.SolicitacaoManIluminacaoPublicaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/solicitacao-man-iluminacao-publica")
public class SolicitacaoManIluminacaoPublicaController {

    private final SolicitacaoManIluminacaoPublicaService service;

    @Autowired
    public SolicitacaoManIluminacaoPublicaController(SolicitacaoManIluminacaoPublicaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SolicitacaoManIluminacaoPublicaResponseDto> salvar(@Valid @RequestBody SolicitacaoManIluminacaoPublicaCreateDto createDto) {
        SolicitacaoManIluminacaoPublicaResponseDto solicitacao = service.salvar(createDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(solicitacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolicitacaoManIluminacaoPublicaResponseDto> getById(@PathVariable Long id) {
        SolicitacaoManIluminacaoPublicaResponseDto solicitacao = service.getById(id);
        return ResponseEntity.ok(solicitacao);
    }

    @GetMapping
    public ResponseEntity<PageableDto> getAllSolicitacoes(Pageable pageable) {
        Page<SolicitacaoManIluminacaoPublicaProjection> solicitacoes = service.getAll(pageable);
        return ResponseEntity.ok(PageableMapper.toDto(solicitacoes));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<SolicitacaoManIluminacaoPublicaResponseDto> update(@RequestBody SolicitacaoManIluminacaoPublicaUpdateDto dto, @PathVariable Long id) {
        SolicitacaoManIluminacaoPublicaResponseDto solicitacao = service.update(dto, id);
        return ResponseEntity.ok(solicitacao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
