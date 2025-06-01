package com.ifba.proj_inov.api.mapper;

import com.ifba.proj_inov.api.dto.UsuarioCreateDto;
import com.ifba.proj_inov.api.dto.UsuarioResponseDto;
import com.ifba.proj_inov.core.entities.Usuarios;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UsuariosMapper {

    public static Usuarios toEntity(UsuarioCreateDto dto){
        return new ModelMapper().map(dto, Usuarios.class);
    }

    public static UsuarioResponseDto toDto(Usuarios usuario){
        return new ModelMapper().map(usuario, UsuarioResponseDto.class);
    }
}
