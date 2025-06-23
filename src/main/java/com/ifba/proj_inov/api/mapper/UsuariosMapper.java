package com.ifba.proj_inov.api.mapper;

import com.ifba.proj_inov.api.dto.UsuariosCreateDto;
import com.ifba.proj_inov.api.dto.UsuariosResponseDto;
import com.ifba.proj_inov.core.entitites.Usuario;
import org.modelmapper.ModelMapper;

public class UsuariosMapper {
    public static Usuario toEntity(UsuariosCreateDto dto){
        return new ModelMapper().map(dto, Usuario.class);
    }

    public static UsuariosResponseDto toDto(Usuario usuario){
        return new ModelMapper().map(usuario, UsuariosResponseDto.class);
    }
}
