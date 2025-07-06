package com.ifba.proj_inov.api.controller;

import com.ifba.proj_inov.api.dto.PageableDto;
import com.ifba.proj_inov.api.dto.DenunciaCreateDto;
import com.ifba.proj_inov.api.dto.DenunciaResponseDto;
import com.ifba.proj_inov.api.dto.DenunciaUpdateDto;
import com.ifba.proj_inov.api.mapper.PageableMapper;
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

    @Autowired
    public DenunciaController(DenunciaService service) {
        this.service = service;
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

}
