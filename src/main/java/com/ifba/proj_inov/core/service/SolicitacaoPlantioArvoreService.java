package com.ifba.proj_inov.core.service;

import com.ifba.proj_inov.api.dto.SolicitacaoPlantioArvoreCreateDto;
import com.ifba.proj_inov.api.dto.SolicitacaoPlantioArvoreResponseDto;
import com.ifba.proj_inov.api.dto.SolicitacaoPlantioArvoreUpdateDto;
import com.ifba.proj_inov.core.entitites.SolicitacaoPlantioArvore;
import com.ifba.proj_inov.core.repository.SolicitacaoPlantioArvoreRepository;
import com.ifba.proj_inov.core.repository.projection.SolicitacaoPlantioArvoreProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SolicitacaoPlantioArvoreService {

    private final SolicitacaoPlantioArvoreRepository repository;

    @Autowired
    public SolicitacaoPlantioArvoreService(SolicitacaoPlantioArvoreRepository repository) {
        this.repository = repository;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public SolicitacaoPlantioArvoreResponseDto salvar(SolicitacaoPlantioArvoreCreateDto createDto) {
        SolicitacaoPlantioArvore entity = new SolicitacaoPlantioArvore();
        entity.setDescricao(createDto.getDescricao());
        entity.setDataCriada(createDto.getDataCriada());
        entity.setStatus(createDto.getStatus());
        entity.setSolicitante(createDto.getSolicitante());
        entity.setBairro(createDto.getBairro());
        entity.setNomeRua(createDto.getNomeRua());
        entity.setNomeArvore(createDto.getNomeArvore());
        entity.setNumCasa(createDto.getNumCasa());
        entity = this.repository.save(entity);

        return getSolicitacaoPlantioArvoreResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public SolicitacaoPlantioArvoreResponseDto getById(Long id) {
        SolicitacaoPlantioArvore entity = this.repository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Solicitação com id= %s não encontrado", id))
        );

        return getSolicitacaoPlantioArvoreResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public Page<SolicitacaoPlantioArvoreProjection> getAll(Pageable pageable) {
        return this.repository.findAllPageable(pageable);
    }

    @Transactional
    public SolicitacaoPlantioArvoreResponseDto update(SolicitacaoPlantioArvoreUpdateDto dto, Long id) {
        SolicitacaoPlantioArvore entity = this.repository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Solicitação com id= %s não encontrado", id))
        );

        if (dto.getDescricao() != null) {
            entity.setDescricao(dto.getDescricao());
        }

        entity = this.repository.save(entity);

        return getSolicitacaoPlantioArvoreResponseDto(entity);
    }

    @Transactional
    public void delete(Long id) {
        SolicitacaoPlantioArvore solicitacao = repository.getById(id);
        repository.delete(solicitacao);
    }

    private static SolicitacaoPlantioArvoreResponseDto getSolicitacaoPlantioArvoreResponseDto(SolicitacaoPlantioArvore entity) {
        SolicitacaoPlantioArvoreResponseDto responseDto = new SolicitacaoPlantioArvoreResponseDto();
        responseDto.setId(entity.getId());
        responseDto.setDescricao(entity.getDescricao());
        responseDto.setStatus(entity.getStatus());
        responseDto.setSolicitante(entity.getSolicitante());
        responseDto.setBairro(entity.getBairro());
        responseDto.setNomeRua(entity.getNomeRua());
        responseDto.setNomeArvore(entity.getNomeArvore());
        responseDto.setNumCasa(entity.getNumCasa());
        return responseDto;
    }
}

