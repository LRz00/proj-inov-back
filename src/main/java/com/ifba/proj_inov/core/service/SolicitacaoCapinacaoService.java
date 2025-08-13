package com.ifba.proj_inov.core.service;


import com.ifba.proj_inov.api.dto.SolicitacaoCapinacaoCreateDto;
import com.ifba.proj_inov.api.dto.SolicitacaoCapinacaoResponseDto;
import com.ifba.proj_inov.api.dto.SolicitacaoCapinacaoUpdateDto;
import com.ifba.proj_inov.core.entitites.SolicitacaoCapinacao;
import com.ifba.proj_inov.core.repository.SolicitacaoCapinacaoRepository;
import com.ifba.proj_inov.core.repository.SolicitacaoCapinacaoRepository;
import com.ifba.proj_inov.core.repository.projection.SolicitacaoCapinacaoProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SolicitacaoCapinacaoService {

    private final SolicitacaoCapinacaoRepository repository;

    @Autowired
    public SolicitacaoCapinacaoService(SolicitacaoCapinacaoRepository repository) {
        this.repository = repository;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public SolicitacaoCapinacaoResponseDto salvar(SolicitacaoCapinacaoCreateDto createDto) {
        SolicitacaoCapinacao entity = new SolicitacaoCapinacao();
        entity.setDescricao(createDto.getDescricao());
        entity.setDataCriada(createDto.getDataCriada());
        entity.setStatus(createDto.getStatus());
        entity.setSolicitante(createDto.getSolicitante());
        entity.setBairro(createDto.getBairro());
        entity.setNomeRua(createDto.getNomeRua());
        entity = this.repository.save(entity);

        SolicitacaoCapinacaoResponseDto responseDto = getSolicitacaoCapinacaoResponseDto(entity);

        return responseDto;
    }

    @Transactional(readOnly = true)
    public SolicitacaoCapinacaoResponseDto getById(Long id) {
        SolicitacaoCapinacao entity = this.repository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Solicitação com id= %s não encontrado", id))
        );

        SolicitacaoCapinacaoResponseDto responseDto = getSolicitacaoCapinacaoResponseDto(entity);

        return responseDto;
    }

    @Transactional(readOnly = true)
    public Page<SolicitacaoCapinacaoProjection> getAll(Pageable pageable) {
        return this.repository.findAllPageable(pageable);
    }

    @Transactional
    public SolicitacaoCapinacaoResponseDto update(SolicitacaoCapinacaoUpdateDto dto, Long id) {
        SolicitacaoCapinacao entity = this.repository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Solicitação com id= %s não encontrado", id))
        );

        if (dto.getDescricao() != null) {
            entity.setDescricao(dto.getDescricao());
        }

        if (dto.getComentarios() != null) {
            entity.setComentarios(dto.getComentarios());
        }

        entity = this.repository.save(entity);

        SolicitacaoCapinacaoResponseDto responseDto = getSolicitacaoCapinacaoResponseDto(entity);

        return responseDto;
    }

    @Transactional
    public void delete(Long id) {
        SolicitacaoCapinacao solicitacao = repository.getById(id);
        repository.delete(solicitacao);
    }

    private static SolicitacaoCapinacaoResponseDto getSolicitacaoCapinacaoResponseDto(SolicitacaoCapinacao entity) {
        SolicitacaoCapinacaoResponseDto responseDto = new SolicitacaoCapinacaoResponseDto();
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
