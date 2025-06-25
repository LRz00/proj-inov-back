package com.ifba.proj_inov.core.service;

import com.ifba.proj_inov.api.dto.SolicitacaoManIluminacaoPublicaCreateDto;
import com.ifba.proj_inov.api.dto.SolicitacaoManIluminacaoPublicaResponseDto;
import com.ifba.proj_inov.api.dto.SolicitacaoManIluminacaoPublicaUpdateDto;
import com.ifba.proj_inov.core.entitites.SolicitacaoManIluminacaoPublica;
import com.ifba.proj_inov.core.repository.SolicitacaoManIluminacaoPublicaRepository;
import com.ifba.proj_inov.core.repository.projection.SolicitacaoManIluminacaoPublicaProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SolicitacaoManIluminacaoPublicaService {

    private final SolicitacaoManIluminacaoPublicaRepository repository;

    @Autowired
    public SolicitacaoManIluminacaoPublicaService(SolicitacaoManIluminacaoPublicaRepository repository) {
        this.repository = repository;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public SolicitacaoManIluminacaoPublicaResponseDto salvar(SolicitacaoManIluminacaoPublicaCreateDto createDto) {
        SolicitacaoManIluminacaoPublica entity = new SolicitacaoManIluminacaoPublica();
        entity.setDescricao(createDto.getDescricao());
        entity.setDataCriada(createDto.getDataCriada());
        entity.setStatus(createDto.getStatus());
        entity.setSolicitante(createDto.getSolicitante());
        entity.setBairro(createDto.getBairro());
        entity.setNomeRua(createDto.getNomeRua());
        entity = this.repository.save(entity);

        SolicitacaoManIluminacaoPublicaResponseDto responseDto = getSolicitacaoManIluminacaoPublicaResponseDto(entity);

        return responseDto;
    }

    @Transactional(readOnly = true)
    public SolicitacaoManIluminacaoPublicaResponseDto getById(Long id) {
        SolicitacaoManIluminacaoPublica entity = this.repository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Solicitação com id= %s não encontrado", id))
        );

        SolicitacaoManIluminacaoPublicaResponseDto responseDto = getSolicitacaoManIluminacaoPublicaResponseDto(entity);

        return responseDto;
    }

    @Transactional(readOnly = true)
    public Page<SolicitacaoManIluminacaoPublicaProjection> getAll(Pageable pageable) {
        return this.repository.findAllPageable(pageable);
    }

    @Transactional
    public SolicitacaoManIluminacaoPublicaResponseDto update(SolicitacaoManIluminacaoPublicaUpdateDto dto, Long id) {
        SolicitacaoManIluminacaoPublica entity = this.repository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Solicitação com id= %s não encontrado", id))
        );

        if (dto.getDescricao() != null) {
            entity.setDescricao(dto.getDescricao());
        }

        if (dto.getComentarios() != null) {
            entity.setComentarios(dto.getComentarios());
        }

        entity = this.repository.save(entity);

        SolicitacaoManIluminacaoPublicaResponseDto responseDto = getSolicitacaoManIluminacaoPublicaResponseDto(entity);

        return responseDto;
    }

    @Transactional
    public void delete(Long id) {
        SolicitacaoManIluminacaoPublica solicitacao = repository.getById(id);
        repository.delete(solicitacao);
    }

    private static SolicitacaoManIluminacaoPublicaResponseDto getSolicitacaoManIluminacaoPublicaResponseDto(SolicitacaoManIluminacaoPublica entity) {
        SolicitacaoManIluminacaoPublicaResponseDto responseDto = new SolicitacaoManIluminacaoPublicaResponseDto();
        responseDto.setId(entity.getId());
        responseDto.setDescricao(entity.getDescricao());
        responseDto.setComentarios(entity.getComentarios());
        responseDto.setDataCriada(entity.getDataCriada());
        responseDto.setStatus(entity.getStatus());
        responseDto.setSolicitante(entity.getSolicitante());
        responseDto.setBairro(entity.getBairro());
        responseDto.setNomeRua(entity.getNomeRua());
        return responseDto;
    }
}
