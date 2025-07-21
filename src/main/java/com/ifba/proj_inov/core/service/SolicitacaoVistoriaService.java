package com.ifba.proj_inov.core.service;

import com.ifba.proj_inov.api.dto.SolicitacaoVistoriaCreateDto;
import com.ifba.proj_inov.api.dto.SolicitacaoVistoriaResponseDto;
import com.ifba.proj_inov.api.dto.SolicitacaoVistoriaUpdateDto;
import com.ifba.proj_inov.core.entitites.SolicitacaoVistoria;
import com.ifba.proj_inov.core.repository.SolicitacaoVistoriaRepository;
import com.ifba.proj_inov.core.repository.projection.SolicitacaoVistoriaProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SolicitacaoVistoriaService {

    private final SolicitacaoVistoriaRepository repository;

    @Autowired
    public SolicitacaoVistoriaService(SolicitacaoVistoriaRepository repository) {
        this.repository = repository;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public SolicitacaoVistoriaResponseDto salvar(SolicitacaoVistoriaCreateDto createDto) {
        SolicitacaoVistoria entity = new SolicitacaoVistoria();
        entity.setDescricao(createDto.getDescricao());
        entity.setDataCriada(createDto.getDataCriada());
        entity.setStatus(createDto.getStatus());
        entity.setSolicitante(createDto.getSolicitante());
        entity.setBairro(createDto.getBairro());
        entity.setNomeRua(createDto.getNomeRua());
        entity.setNumCasa(createDto.getNumCasa());
        entity = this.repository.save(entity);

        return getSolicitacaoVistoriaResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public SolicitacaoVistoriaResponseDto getById(Long id) {
        SolicitacaoVistoria entity = this.repository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Solicitação com id= %s não encontrado", id))
        );

        return getSolicitacaoVistoriaResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public Page<SolicitacaoVistoriaProjection> getAll(Pageable pageable) {
        return this.repository.findAllPageable(pageable);
    }

    @Transactional
    public SolicitacaoVistoriaResponseDto update(SolicitacaoVistoriaUpdateDto dto, Long id) {
        SolicitacaoVistoria entity = this.repository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Solicitação com id= %s não encontrado", id))
        );

        if (dto.getDescricao() != null) {
            entity.setDescricao(dto.getDescricao());
        }

        entity = this.repository.save(entity);

        return getSolicitacaoVistoriaResponseDto(entity);
    }

    @Transactional
    public void delete(Long id) {
        SolicitacaoVistoria solicitacao = repository.getById(id);
        repository.delete(solicitacao);
    }

    private static SolicitacaoVistoriaResponseDto getSolicitacaoVistoriaResponseDto(SolicitacaoVistoria entity) {
        SolicitacaoVistoriaResponseDto responseDto = new SolicitacaoVistoriaResponseDto();
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
