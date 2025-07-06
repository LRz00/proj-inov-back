package com.ifba.proj_inov.core.service;

import com.ifba.proj_inov.api.dto.DenunciaCreateDto;
import com.ifba.proj_inov.api.dto.DenunciaResponseDto;
import com.ifba.proj_inov.api.dto.DenunciaUpdateDto;
import com.ifba.proj_inov.core.entitites.Denuncia;
import com.ifba.proj_inov.core.repository.DenunciaRepository;
import com.ifba.proj_inov.core.repository.projection.DenunciaProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DenunciaService {

    private final DenunciaRepository repository;

    @Autowired
    public DenunciaService(DenunciaRepository repository) {
        this.repository = repository;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public DenunciaResponseDto salvar(DenunciaCreateDto createDto) {
        Denuncia entity = new Denuncia();
        entity.setDescricao(createDto.getDescricao());
        entity.setDataCriada(createDto.getDataCriada());
        entity.setStatus(createDto.getStatus());
        entity.setSolicitante(createDto.getSolicitante());
        entity.setPrioridade(createDto.getPrioridade());
        entity.setDenuncia(createDto.getDenuncia());
        entity.setDataConcluida(createDto.getDataCriada());
        entity = this.repository.save(entity);

        DenunciaResponseDto responseDto = getDenunciaResponseDto(entity);

        return responseDto;
    }

    @Transactional(readOnly = true)
    public DenunciaResponseDto getById(Long id) {
        Denuncia entity = this.repository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Denúncia com id= %s não encontrado", id))
        );

        DenunciaResponseDto responseDto = getDenunciaResponseDto(entity);

        return responseDto;
    }

    @Transactional(readOnly = true)
    public Page<DenunciaProjection> getAll(Pageable pageable) {
        return this.repository.findAllPageable(pageable);
    }

    @Transactional
    public DenunciaResponseDto update(DenunciaUpdateDto dto, Long id) {
        Denuncia entity = this.repository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Denúncia com id= %s não encontrado", id))
        );

        if (dto.getDescricao() != null) {
            entity.setDescricao(dto.getDescricao());
        }

        if (dto.getComentarios() != null) {
            entity.setComentarios(dto.getComentarios());
        }

        entity = this.repository.save(entity);

        DenunciaResponseDto responseDto = getDenunciaResponseDto(entity);

        return responseDto;
    }

    @Transactional
    public void delete(Long id) {
        Denuncia denuncia = repository.getById(id);
        repository.delete(denuncia);
    }

    private static DenunciaResponseDto getDenunciaResponseDto(Denuncia entity) {
        DenunciaResponseDto responseDto = new DenunciaResponseDto();
        responseDto.setId(entity.getId());
        responseDto.setDescricao(entity.getDescricao());
        responseDto.setComentarios(entity.getComentarios());
        responseDto.setDataCriada(entity.getDataCriada());
        responseDto.setStatus(entity.getStatus());
        responseDto.setSolicitante(entity.getSolicitante());
        responseDto.setPrioridade(entity.getPrioridade());
        responseDto.setDenuncia(entity.getDenuncia());
        responseDto.setDataConcluida(entity.getDataConcluida());
        return responseDto;
    }
}
