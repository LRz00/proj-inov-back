package com.ifba.proj_inov.api.controller;

import com.ifba.proj_inov.Paciente.infrastructure.mapper.ObjectMapperUtil;
import com.ifba.proj_inov.api.dto.exame.ExameDto;
import com.ifba.proj_inov.core.service.ExameService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/exame")
@CrossOrigin("*")
@RequiredArgsConstructor
public class ExameController {

    private final ExameService exameService;
    private final ObjectMapperUtil objectMapperUtil;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ExameDto> save(@RequestBody @Valid ExameDto exameDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(exameService.save(exameDto));
    }
}
