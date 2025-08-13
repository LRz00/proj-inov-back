package com.ifba.proj_inov.api.controller;


import com.ifba.proj_inov.api.dto.PageableDto;
import com.ifba.proj_inov.api.dto.SolicitacaoCapinacaoCreateDto;
import com.ifba.proj_inov.api.dto.SolicitacaoCapinacaoResponseDto;
import com.ifba.proj_inov.api.dto.SolicitacaoCapinacaoUpdateDto;
import com.ifba.proj_inov.api.mapper.PageableMapper;
import com.ifba.proj_inov.core.repository.projection.SolicitacaoCapinacaoProjection;
import com.ifba.proj_inov.core.service.SolicitacaoCapinacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("solicitacao-capinacao")
public class SolicitacaoCapinacaoController {

    private final SolicitacaoCapinacaoService service;

    @Autowired
    public SolicitacaoCapinacaoController(SolicitacaoCapinacaoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SolicitacaoCapinacaoResponseDto> salvar(@Valid @RequestBody SolicitacaoCapinacaoCreateDto createDto) {
        SolicitacaoCapinacaoResponseDto solicitacao = service.salvar(createDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(solicitacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolicitacaoCapinacaoResponseDto> getById(@PathVariable Long id) {
        SolicitacaoCapinacaoResponseDto solicitacao = service.getById(id);
        return ResponseEntity.ok(solicitacao);
    }

    @GetMapping
    public ResponseEntity<PageableDto> getAllSolicitacoes(Pageable pageable) {
        Page<SolicitacaoCapinacaoProjection> solicitacoes = service.getAll(pageable);
        return ResponseEntity.ok(PageableMapper.toDto(solicitacoes));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<SolicitacaoCapinacaoResponseDto> update(@RequestBody SolicitacaoCapinacaoUpdateDto dto, @PathVariable Long id) {
        SolicitacaoCapinacaoResponseDto solicitacao = service.update(dto, id);
        return ResponseEntity.ok(solicitacao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
