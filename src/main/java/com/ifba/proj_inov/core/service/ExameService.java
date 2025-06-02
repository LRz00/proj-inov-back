package com.ifba.proj_inov.core.service;

import com.ifba.proj_inov.Paciente.infrastructure.mapper.ObjectMapperUtil;
import com.ifba.proj_inov.api.dto.exame.ExameDto;
import com.ifba.proj_inov.core.entities.Exame;
import com.ifba.proj_inov.core.repository.ExameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExameService {
    private final ExameRepository exameRepository;
    private final ObjectMapperUtil objectMapperUtil;

    public ExameDto save(ExameDto exameDto) {
        Exame exame = objectMapperUtil.map(exameDto, Exame.class);
        exame = exameRepository.save(exame);
        return objectMapperUtil.map(exame, ExameDto.class);
    }

    public Exame findById(Long exameId) {
        return exameRepository.findById(exameId)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado!"));
    }

}
