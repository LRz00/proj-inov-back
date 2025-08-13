package com.ifba.proj_inov.core.service;

import com.ifba.proj_inov.api.dto.SolicitacaoEnterroAberturaCovaCreateDto;
import com.ifba.proj_inov.api.dto.SolicitacaoEnterroAberturaCovaResponseDto;
import com.ifba.proj_inov.api.dto.SolicitacaoEnterroAberturaCovaUpdateDto;
import com.ifba.proj_inov.core.entitites.SolicitacaoEnterroAberturaCova;
import com.ifba.proj_inov.core.repository.SolicitacaoEnterroAberturaCovaRepository;
import com.ifba.proj_inov.core.repository.projection.SolicitacaoEnterroAberturaCovaProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SolicitacaoEnterroAberturaCovaService {

    private final SolicitacaoEnterroAberturaCovaRepository repository;

    @Autowired
    public SolicitacaoEnterroAberturaCovaService(SolicitacaoEnterroAberturaCovaRepository repository) {
        this.repository = repository;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public SolicitacaoEnterroAberturaCovaResponseDto salvar(SolicitacaoEnterroAberturaCovaCreateDto createDto) {
        SolicitacaoEnterroAberturaCova entity = new SolicitacaoEnterroAberturaCova();
        entity.setDescricao(createDto.getDescricao());
        entity.setDataCriada(createDto.getDataCriada());
        entity.setStatus(createDto.getStatus());
        entity.setSolicitante(createDto.getSolicitante());
        entity.setBairro(createDto.getBairro());
        entity.setNomeRua(createDto.getNomeRua());
        entity.setNumCasa(createDto.getNumCasa());
        entity = this.repository.save(entity);

        return getSolicitacaoEnterroAberturaCovaResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public SolicitacaoEnterroAberturaCovaResponseDto getById(Long id) {
        SolicitacaoEnterroAberturaCova entity = this.repository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Solicitação com id= %s não encontrado", id))
        );

        return getSolicitacaoEnterroAberturaCovaResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public Page<SolicitacaoEnterroAberturaCovaProjection> getAll(Pageable pageable) {
        return this.repository.findAllPageable(pageable);
    }

    @Transactional
    public SolicitacaoEnterroAberturaCovaResponseDto update(SolicitacaoEnterroAberturaCovaUpdateDto dto, Long id) {
        SolicitacaoEnterroAberturaCova entity = this.repository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Solicitação com id= %s não encontrado", id))
        );

        if (dto.getDescricao() != null) {
            entity.setDescricao(dto.getDescricao());
        }

        entity = this.repository.save(entity);

        return getSolicitacaoEnterroAberturaCovaResponseDto(entity);
    }

    @Transactional
    public void delete(Long id) {
        SolicitacaoEnterroAberturaCova solicitacao = repository.getById(id);
        repository.delete(solicitacao);
    }

    private static SolicitacaoEnterroAberturaCovaResponseDto getSolicitacaoEnterroAberturaCovaResponseDto(SolicitacaoEnterroAberturaCova entity) {
        SolicitacaoEnterroAberturaCovaResponseDto responseDto = new SolicitacaoEnterroAberturaCovaResponseDto();
        responseDto.setId(entity.getId());
        responseDto.setDescricao(entity.getDescricao());
        responseDto.setStatus(entity.getStatus());
        responseDto.setSolicitante(entity.getSolicitante());
        responseDto.setBairro(entity.getBairro());
        responseDto.setNomeRua(entity.getNomeRua());
        responseDto.setNumCasa(entity.getNumCasa());
        return responseDto;
    }
}

