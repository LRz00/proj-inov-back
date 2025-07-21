package com.ifba.proj_inov.api.mapper;

import com.ifba.proj_inov.api.dto.SolicitacaoEventosCreateDto;
import com.ifba.proj_inov.api.dto.SolicitacaoEventosResponseDto;
import com.ifba.proj_inov.core.entitites.SolicitacaoEventos;
import org.modelmapper.ModelMapper;

public class SolicitacaoEventosMapper {
    public static SolicitacaoEventos toEntity(SolicitacaoEventosCreateDto dto) {
        return new ModelMapper().map(dto, SolicitacaoEventos.class);
    }

    public static SolicitacaoEventosResponseDto toDto(SolicitacaoEventos entity) {
        return new ModelMapper().map(entity, SolicitacaoEventosResponseDto.class);
    }
}

