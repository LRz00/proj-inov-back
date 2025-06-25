package com.ifba.proj_inov.api.mapper;

import com.ifba.proj_inov.api.dto.SolicitacaoManViaPublicaCreateDto;
import com.ifba.proj_inov.api.dto.SolicitacaoManViaPublicaResponseDto;
import com.ifba.proj_inov.core.entitites.Solicitacao;
import com.ifba.proj_inov.core.entitites.SolicitacaoManViaPublica;
import org.modelmapper.ModelMapper;

public class SolicitacaoManViaPublicaMapper {

    public static SolicitacaoManViaPublica toEntity(SolicitacaoManViaPublicaCreateDto dto) {
        return new ModelMapper().map(dto, SolicitacaoManViaPublica.class);
    }

    public static SolicitacaoManViaPublicaResponseDto toDto(SolicitacaoManViaPublica solicitacaoManViaPublica) {
        return new ModelMapper().map(solicitacaoManViaPublica, SolicitacaoManViaPublicaResponseDto.class);
    }

}
