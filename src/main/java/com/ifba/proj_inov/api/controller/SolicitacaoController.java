package com.ifba.proj_inov.api.controller;

import com.ifba.proj_inov.api.dto.PageableDto;
import com.ifba.proj_inov.api.dto.SolicitacoesCreateDto;
import com.ifba.proj_inov.api.dto.SolicitacoesResponseDto;
import com.ifba.proj_inov.api.dto.SolicitacoesUpdateDto;
import com.ifba.proj_inov.api.mapper.PageableMapper;
import com.ifba.proj_inov.api.mapper.SolicitacoesMapper;
import com.ifba.proj_inov.core.entitites.Solicitacao;
import com.ifba.proj_inov.core.repository.projection.SolicitacoesProjection;
import com.ifba.proj_inov.core.repository.projection.UsuariosProjection;
import com.ifba.proj_inov.core.service.SolicitacoesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/solicitacoes")
public class SolicitacaoController {

    private final SolicitacoesService solicitacaoService;

    @Autowired
    public SolicitacaoController(SolicitacoesService solicitacaoService) {
        this.solicitacaoService = solicitacaoService;
    }

    @PostMapping
    public ResponseEntity<SolicitacoesResponseDto> salvar(@Valid @RequestBody SolicitacoesCreateDto createDto) {
        Solicitacao solicitacao = solicitacaoService.salvar(SolicitacoesMapper.toEntity(createDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(SolicitacoesMapper.toDto(solicitacao));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolicitacoesResponseDto> getById(@PathVariable Long id) {
        Solicitacao solicitacao = solicitacaoService.getById(id);
        return ResponseEntity.ok(SolicitacoesMapper.toDto(solicitacao));
    }

    @GetMapping
    public ResponseEntity<PageableDto> getAllSolicitacoes(Pageable pageable) {
        Page<SolicitacoesProjection> solicitacoes = solicitacaoService.getAll(pageable);
        return ResponseEntity.ok(PageableMapper.toDto(solicitacoes));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<SolicitacoesResponseDto> update(@RequestBody SolicitacoesUpdateDto dto, @PathVariable Long id) {
        Solicitacao solicitacao = solicitacaoService.update(dto, id);
        return ResponseEntity.ok(SolicitacoesMapper.toDto(solicitacao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        solicitacaoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
