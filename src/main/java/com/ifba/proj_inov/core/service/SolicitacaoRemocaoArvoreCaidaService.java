package com.ifba.proj_inov.core.service;


import com.ifba.proj_inov.api.dto.*;
import com.ifba.proj_inov.core.entitites.SolicitacaoManViaPublica;
import com.ifba.proj_inov.core.entitites.SolicitacaoRemocaoArvoreCaida;
import com.ifba.proj_inov.core.repository.SolicitacaoRemocaoArvoreCaidaRepository;
import com.ifba.proj_inov.core.repository.projection.SolicitacaoRemocaoArvoreCaidaProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SolicitacaoRemocaoArvoreCaidaService {

    private final SolicitacaoRemocaoArvoreCaidaRepository repository;

    @Autowired
    public SolicitacaoRemocaoArvoreCaidaService(SolicitacaoRemocaoArvoreCaidaRepository repository) {
        this.repository = repository;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public SolicitacaoRemocaoArvoreCaidaResponseDto salvar(SolicitacaoRemocaoArvoreCaidaCreateDto createDto) {
        SolicitacaoRemocaoArvoreCaida entity = new SolicitacaoRemocaoArvoreCaida();
        entity.setDescricao(createDto.getDescricao());
        entity.setDataCriada(createDto.getDataCriada());
        entity.setStatus(createDto.getStatus());
        entity.setSolicitante(createDto.getSolicitante());
        entity.setBairro(createDto.getBairro());
        entity.setNomeRua(createDto.getNomeRua());
        entity = this.repository.save(entity);

        SolicitacaoRemocaoArvoreCaidaResponseDto responseDto = getSolicitacaoRemocaoArvoreCaidaResponseDto(entity);

        return responseDto;
    }

    @Transactional(readOnly = true)
    public SolicitacaoRemocaoArvoreCaidaResponseDto getById(Long id) {
        SolicitacaoRemocaoArvoreCaida entity = this.repository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Solicitação com id= %s não encontrado", id))
        );

        SolicitacaoRemocaoArvoreCaidaResponseDto responseDto = getSolicitacaoRemocaoArvoreCaidaResponseDto(entity);

        return responseDto;
    }

    @Transactional(readOnly = true)
    public Page<SolicitacaoRemocaoArvoreCaidaProjection> getAll(Pageable pageable) {
        return this.repository.findAllPageable(pageable);
    }

    @Transactional
    public SolicitacaoRemocaoArvoreCaidaResponseDto update(SolicitacaoRemocaoArvoreCaidaUpdateDto dto, Long id) {
        SolicitacaoRemocaoArvoreCaida entity = this.repository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Solicitação com id= %s não encontrado", id))
        );

        if (dto.getDescricao() != null) {
            entity.setDescricao(dto.getDescricao());
        }

        if (dto.getComentarios() != null) {
            entity.setComentarios(dto.getComentarios());
        }

        entity = this.repository.save(entity);

        SolicitacaoRemocaoArvoreCaidaResponseDto responseDto = getSolicitacaoRemocaoArvoreCaidaResponseDto(entity);

        return responseDto;
    }

    @Transactional
    public void delete(Long id) {
        SolicitacaoRemocaoArvoreCaida solicitacao = repository.getById(id);
        repository.delete(solicitacao);
    }

    private static SolicitacaoRemocaoArvoreCaidaResponseDto getSolicitacaoRemocaoArvoreCaidaResponseDto(SolicitacaoRemocaoArvoreCaida entity) {
        SolicitacaoRemocaoArvoreCaidaResponseDto responseDto = new SolicitacaoRemocaoArvoreCaidaResponseDto();
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
