package com.ifba.proj_inov.api.controller;

import com.ifba.proj_inov.api.dto.*;
import com.ifba.proj_inov.api.mapper.PageableMapper;
import com.ifba.proj_inov.core.entitites.Denuncia;
import com.ifba.proj_inov.core.entitites.SolicitacaoManIluminacaoPublica;
import com.ifba.proj_inov.core.repository.DenunciaRepository;
import com.ifba.proj_inov.core.repository.projection.DenunciaProjection;
import com.ifba.proj_inov.core.service.DenunciaService;
import com.ifba.proj_inov.core.service.DenunciaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/denuncias")
public class DenunciaController {

    private final DenunciaService service;
    private final DenunciaRepository repository;

    @Autowired
    public DenunciaController(DenunciaService service, DenunciaRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<DenunciaResponseDto> salvar(@Valid @RequestBody DenunciaCreateDto createDto) {
        DenunciaResponseDto denuncia = service.salvar(createDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(denuncia);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DenunciaResponseDto> getById(@PathVariable Long id) {
        DenunciaResponseDto denuncia = service.getById(id);
        return ResponseEntity.ok(denuncia);
    }

    @GetMapping
    public ResponseEntity<PageableDto> getAllSolicitacoes(Pageable pageable) {
        Page<DenunciaProjection> denuncias = service.getAll(pageable);
        return ResponseEntity.ok(PageableMapper.toDto(denuncias));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<DenunciaResponseDto> update(@RequestBody DenunciaUpdateDto dto, @PathVariable Long id) {
        DenunciaResponseDto denuncia = service.update(dto, id);
        return ResponseEntity.ok(denuncia);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/avaliar")
    public ResponseEntity<DenunciaResponseDto> avaliarSolicitacao(
            @PathVariable Long id,
            @RequestParam Double nota) {

        return repository.findById(id)
                .map(denuncia -> {
                    denuncia.adicionarNota(nota);
                    Denuncia denunciaAtualizada = repository.save(denuncia);

                    DenunciaResponseDto responseDto = service.getDenunciaResponseDto(denunciaAtualizada);
                    return ResponseEntity.ok(responseDto);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/media")
    public ResponseEntity<Double> obterMediaAvaliacoes(@PathVariable Long id) {
        return repository.findById(id)
                .map(denuncia -> ResponseEntity.ok(denuncia.calcularMedia()))
                .orElse(ResponseEntity.notFound().build());
    }

}
