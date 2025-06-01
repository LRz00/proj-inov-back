package com.ifba.proj_inov.api.controller;

import com.ifba.proj_inov.api.dto.PageableDto;
import com.ifba.proj_inov.api.dto.UsuarioCreateDto;
import com.ifba.proj_inov.api.dto.UsuarioResponseDto;
import com.ifba.proj_inov.api.mapper.PageableMapper;
import com.ifba.proj_inov.api.mapper.UsuariosMapper;
import com.ifba.proj_inov.core.entities.Usuarios;
import com.ifba.proj_inov.core.repository.projection.UsuariosProjection;
import com.ifba.proj_inov.core.service.UsuariosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private final UsuariosService usuariosService;

    public UsuariosController(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDto> salvar(@Valid @RequestBody UsuarioCreateDto createDto){
        Usuarios usuario = usuariosService.salvar(UsuariosMapper.toEntity(createDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(UsuariosMapper.toDto(usuario));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> getById(@PathVariable Long id){
        Usuarios usuarios = usuariosService.getById(id);
        return ResponseEntity.ok(UsuariosMapper.toDto(usuarios));
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<UsuarioResponseDto> getByCpf(@PathVariable String cpf){
        Usuarios usuarios = usuariosService.getByCpf(cpf);
        return ResponseEntity.ok(UsuariosMapper.toDto(usuarios));
    }

    @GetMapping
    public ResponseEntity<PageableDto> getAllUsuarios(Pageable pageable){
        Page<UsuariosProjection> usuarios = usuariosService.getAll(pageable);
        return  ResponseEntity.ok(PageableMapper.toDto(usuarios));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        usuariosService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
