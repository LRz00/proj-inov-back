package com.ifba.proj_inov.api.controller;

import com.ifba.proj_inov.api.dto.PageableDto;
import com.ifba.proj_inov.api.dto.UsuariosCreateDto;
import com.ifba.proj_inov.api.dto.UsuariosResponseDto;
import com.ifba.proj_inov.api.mapper.PageableMapper;
import com.ifba.proj_inov.api.mapper.UsuariosMapper;
import com.ifba.proj_inov.core.entitites.Usuario;
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

    private final UsuariosService usuariosService;

    @Autowired
    public UsuariosController(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    @PostMapping
    public ResponseEntity<UsuariosResponseDto> salvar(@Valid @RequestBody UsuariosCreateDto createDto) {
        Usuario usuario = usuariosService.salvar(UsuariosMapper.toEntity(createDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(UsuariosMapper.toDto(usuario));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuariosResponseDto> getById(@PathVariable Long id) {
        Usuario usuario = usuariosService.getById(id);
        return ResponseEntity.ok(UsuariosMapper.toDto(usuario));
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<UsuariosResponseDto> getByCpf(@PathVariable String cpf) {
        Usuario usuario = usuariosService.getByCpf(cpf);
        return ResponseEntity.ok(UsuariosMapper.toDto(usuario));
    }

    @GetMapping
    public ResponseEntity<PageableDto> getAllUsuarios(Pageable pageable) {
        Page<UsuariosProjection> usuarios = usuariosService.getAll(pageable);
        return ResponseEntity.ok(PageableMapper.toDto(usuarios));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UsuariosResponseDto> getByEmail(@PathVariable String email){
        Usuario usuario = usuariosService.getByEmail(email);
        return ResponseEntity.ok(UsuariosMapper.toDto(usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        usuariosService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
