package com.ifba.proj_inov.api.controller;


import com.ifba.proj_inov.api.dto.PageableDto;
import com.ifba.proj_inov.api.dto.SolicitacaoRemocaoArvoreCaidaCreateDto;
import com.ifba.proj_inov.api.dto.SolicitacaoRemocaoArvoreCaidaResponseDto;
import com.ifba.proj_inov.api.dto.SolicitacaoRemocaoArvoreCaidaUpdateDto;
import com.ifba.proj_inov.api.mapper.PageableMapper;
import com.ifba.proj_inov.core.repository.projection.SolicitacaoRemocaoArvoreCaidaProjection;
import com.ifba.proj_inov.core.service.SolicitacaoRemocaoArvoreCaidaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/solicitacao-remocao-arvore-caida")
public class SolicitacaoRemocaoArvoreCaidaController {

    private final SolicitacaoRemocaoArvoreCaidaService service;

    @Autowired
    public SolicitacaoRemocaoArvoreCaidaController(SolicitacaoRemocaoArvoreCaidaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SolicitacaoRemocaoArvoreCaidaResponseDto> salvar(@Valid @RequestBody SolicitacaoRemocaoArvoreCaidaCreateDto createDto) {
        SolicitacaoRemocaoArvoreCaidaResponseDto solicitacao = service.salvar(createDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(solicitacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolicitacaoRemocaoArvoreCaidaResponseDto> getById(@PathVariable Long id) {
        SolicitacaoRemocaoArvoreCaidaResponseDto solicitacao = service.getById(id);
        return ResponseEntity.ok(solicitacao);
    }

    @GetMapping
    public ResponseEntity<PageableDto> getAllSolicitacoes(Pageable pageable) {
        Page<SolicitacaoRemocaoArvoreCaidaProjection> solicitacoes = service.getAll(pageable);
        return ResponseEntity.ok(PageableMapper.toDto(solicitacoes));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<SolicitacaoRemocaoArvoreCaidaResponseDto> update(@RequestBody SolicitacaoRemocaoArvoreCaidaUpdateDto dto, @PathVariable Long id) {
        SolicitacaoRemocaoArvoreCaidaResponseDto solicitacao = service.update(dto, id);
        return ResponseEntity.ok(solicitacao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
