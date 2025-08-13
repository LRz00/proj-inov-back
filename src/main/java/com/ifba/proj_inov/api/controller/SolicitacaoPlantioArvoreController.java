package com.ifba.proj_inov.api.controller;

import com.ifba.proj_inov.api.dto.PageableDto;
import com.ifba.proj_inov.api.dto.SolicitacaoPlantioArvoreCreateDto;
import com.ifba.proj_inov.api.dto.SolicitacaoPlantioArvoreResponseDto;
import com.ifba.proj_inov.api.dto.SolicitacaoPlantioArvoreUpdateDto;
import com.ifba.proj_inov.api.mapper.PageableMapper;
import com.ifba.proj_inov.core.repository.projection.SolicitacaoPlantioArvoreProjection;
import com.ifba.proj_inov.core.service.SolicitacaoPlantioArvoreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/solicitacao-plantio-arvore")
public class SolicitacaoPlantioArvoreController {

    private final SolicitacaoPlantioArvoreService service;

    @Autowired
    public SolicitacaoPlantioArvoreController(SolicitacaoPlantioArvoreService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SolicitacaoPlantioArvoreResponseDto> salvar(@Valid @RequestBody SolicitacaoPlantioArvoreCreateDto createDto) {
        SolicitacaoPlantioArvoreResponseDto solicitacao = service.salvar(createDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(solicitacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolicitacaoPlantioArvoreResponseDto> getById(@PathVariable Long id) {
        SolicitacaoPlantioArvoreResponseDto solicitacao = service.getById(id);
        return ResponseEntity.ok(solicitacao);
    }

    @GetMapping
    public ResponseEntity<PageableDto> getAllSolicitacoes(Pageable pageable) {
        Page<SolicitacaoPlantioArvoreProjection> solicitacoes = service.getAll(pageable);
        return ResponseEntity.ok(PageableMapper.toDto(solicitacoes));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<SolicitacaoPlantioArvoreResponseDto> update(@RequestBody SolicitacaoPlantioArvoreUpdateDto dto, @PathVariable Long id) {
        SolicitacaoPlantioArvoreResponseDto solicitacao = service.update(dto, id);
        return ResponseEntity.ok(solicitacao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}

