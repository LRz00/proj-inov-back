package com.ifba.proj_inov.api.mapper;

import com.ifba.proj_inov.api.dto.SolicitacoesCreateDto;
import com.ifba.proj_inov.api.dto.SolicitacoesResponseDto;
import com.ifba.proj_inov.core.entitites.Solicitacao;
import org.modelmapper.ModelMapper;

public class SolicitacoesMapper {

    public static Solicitacao toEntity(SolicitacoesCreateDto dto) {
        return new ModelMapper().map(dto, Solicitacao.class);
    }

    public static SolicitacoesResponseDto toDto(Solicitacao solicitacao) {
        return new ModelMapper().map(solicitacao, SolicitacoesResponseDto.class);
    }

}
