package com.ifba.proj_inov.core.service;

import com.ifba.proj_inov.api.dto.SolicitacaoManViaPublicaCreateDto;
import com.ifba.proj_inov.api.dto.SolicitacaoManViaPublicaResponseDto;
import com.ifba.proj_inov.api.dto.SolicitacaoManViaPublicaUpdateDto;
import com.ifba.proj_inov.core.entitites.Solicitacao;
import com.ifba.proj_inov.core.entitites.SolicitacaoManViaPublica;
import com.ifba.proj_inov.core.entitites.enums.SolicitacaoStatusEnum;
import com.ifba.proj_inov.core.repository.SolicitacaoManViaPublicaRepository;
import com.ifba.proj_inov.core.repository.projection.SolicitacaoManViaPublicaProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SolicitacaoManViaPublicaService {

    private final SolicitacaoManViaPublicaRepository repository;

    @Autowired
    public SolicitacaoManViaPublicaService(SolicitacaoManViaPublicaRepository repository) {
        this.repository = repository;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public SolicitacaoManViaPublicaResponseDto salvar(SolicitacaoManViaPublicaCreateDto createDto) {
        SolicitacaoManViaPublica entity = new SolicitacaoManViaPublica();
        entity.setDescricao(createDto.getDescricao());
        entity.setDataCriada(createDto.getDataCriada());
        entity.setStatus(createDto.getStatus());
        entity.setSolicitante(createDto.getSolicitante());
        entity.setBairro(createDto.getBairro());
        entity.setNomeRua(createDto.getNomeRua());
        entity = this.repository.save(entity);

        SolicitacaoManViaPublicaResponseDto responseDto = getSolicitacaoManViaPublicaResponseDto(entity);

        return responseDto;
    }

    @Transactional(readOnly = true)
    public SolicitacaoManViaPublicaResponseDto getById(Long id) {
        SolicitacaoManViaPublica entity = this.repository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Solicitação com id= %s não encontrado", id))
        );

        SolicitacaoManViaPublicaResponseDto responseDto = getSolicitacaoManViaPublicaResponseDto(entity);

        return responseDto;
    }

    @Transactional(readOnly = true)
    public Page<SolicitacaoManViaPublicaProjection> getAll(Pageable pageable) {
        return this.repository.findAllPageable(pageable);
    }

    @Transactional
    public SolicitacaoManViaPublicaResponseDto update(SolicitacaoManViaPublicaUpdateDto dto, Long id) {
        SolicitacaoManViaPublica entity = this.repository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Solicitação com id= %s não encontrado", id))
        );

        if (dto.getDescricao() != null) {
            entity.setDescricao(dto.getDescricao());
        }

        if (dto.getComentarios() != null) {
            entity.setComentarios(dto.getComentarios());
        }

        entity = this.repository.save(entity);

        SolicitacaoManViaPublicaResponseDto responseDto = getSolicitacaoManViaPublicaResponseDto(entity);

        return responseDto;
    }

    @Transactional
    public void delete(Long id) {
        SolicitacaoManViaPublica solicitacao = repository.getById(id);
        repository.delete(solicitacao);
    }

    public SolicitacaoManViaPublicaResponseDto getSolicitacaoManViaPublicaResponseDto(SolicitacaoManViaPublica entity) {
        SolicitacaoManViaPublicaResponseDto responseDto = new SolicitacaoManViaPublicaResponseDto();
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
