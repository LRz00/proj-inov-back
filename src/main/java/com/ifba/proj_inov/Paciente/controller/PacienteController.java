package com.ifba.proj_inov.Paciente.controller;

import com.ifba.proj_inov.Paciente.dto.PacienteGetResponseDto;
import com.ifba.proj_inov.Paciente.dto.PacientePostResquestDto;
import com.ifba.proj_inov.Paciente.entity.Paciente;
import com.ifba.proj_inov.Paciente.service.PacienteService;
import com.ifba.proj_inov.Paciente.infrastructure.mapper.ObjectMapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
@CrossOrigin("*")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteService pacienteService;
    private final ObjectMapperUtil objectMapperUtil;

    // Método para buscar todos os pacientes com paginação
    @GetMapping(path = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<PacienteGetResponseDto>> findAll(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(this.pacienteService.findAll(pageable).map(f -> objectMapperUtil
                        .map(f, PacienteGetResponseDto.class)));
    }

    // Método para buscar pacientes pelo nome
    @GetMapping(path = "/findByName/{NomeCompleto}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PacienteGetResponseDto>> findByNomeCompleto(@PathVariable String nomeCompleto) {
        List<Paciente> pacientes = this.pacienteService.findByNomeCompleto(nomeCompleto);
        List<PacienteGetResponseDto> responseDto = objectMapperUtil.mapAll(pacientes, PacienteGetResponseDto.class);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

        // Método para buscar um paciente pelo ID
        @GetMapping("/paciente/{id}")
        public ResponseEntity<PacienteGetResponseDto> findById(@PathVariable Long id) {
            Paciente paciente = pacienteService.findById(id);
            PacienteGetResponseDto responseDto = objectMapperUtil.map(paciente, PacienteGetResponseDto.class);
            return ResponseEntity.ok(responseDto);
        }

        // Método para salvar um novo Paciente
        @PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<PacienteGetResponseDto> save(@RequestBody @Valid PacientePostResquestDto pacientePostRequestDto) {
            Paciente Paciente = objectMapperUtil.map(pacientePostRequestDto, Paciente.class);
            Paciente savePaciente = pacienteService.save(Paciente);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(objectMapperUtil.map(savePaciente, PacienteGetResponseDto.class));
        }

        // Método para atualizar um Paciente existente
        @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<Void> update(@RequestBody @Valid PacientePostResquestDto pacientePostRequestDto) {
            Paciente paciente = objectMapperUtil.map(pacientePostRequestDto, Paciente.class);
            pacienteService.update(paciente);
            return ResponseEntity.noContent().build();
        }

        // Método para excluir um Paciente pelo ID
        @DeleteMapping(path = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<?> delete(@PathVariable("id") Long id) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(pacienteService.delete(id));
        }


}
