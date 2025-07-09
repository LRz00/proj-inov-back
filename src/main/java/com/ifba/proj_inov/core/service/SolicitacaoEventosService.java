package com.ifba.proj_inov.core.service;

import com.ifba.proj_inov.api.dto.SolicitacaoEventosCreateDto;
import com.ifba.proj_inov.api.dto.SolicitacaoEventosResponseDto;
import com.ifba.proj_inov.api.dto.SolicitacaoEventosUpdateDto;
import com.ifba.proj_inov.api.mapper.SolicitacaoEventosMapper;
import com.ifba.proj_inov.core.entitites.SolicitacaoEventos;
import com.ifba.proj_inov.core.repository.SolicitacaoEventosRepository;
import com.ifba.proj_inov.core.repository.projection.SolicitacaoEventosProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SolicitacaoEventosService {
    private final SolicitacaoEventosRepository repository;

    @Autowired
    public SolicitacaoEventosService(SolicitacaoEventosRepository repository) {
        this.repository = repository;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public SolicitacaoEventosResponseDto salvar(SolicitacaoEventosCreateDto createDto) {
        SolicitacaoEventos entity = SolicitacaoEventosMapper.toEntity(createDto);
        entity = this.repository.save(entity);
        return SolicitacaoEventosMapper.toDto(entity);
    }

    @Transactional(readOnly = true)
    public SolicitacaoEventosResponseDto getById(Long id) {
        SolicitacaoEventos entity = this.repository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Solicitação de evento com id= %s não encontrada", id))
        );
        return SolicitacaoEventosMapper.toDto(entity);
    }

    @Transactional(readOnly = true)
    public Page<SolicitacaoEventosProjection> getAll(Pageable pageable) {
        return this.repository.findAllPageable(pageable);
    }

    @Transactional
    public SolicitacaoEventosResponseDto update(SolicitacaoEventosUpdateDto dto, Long id) {
        SolicitacaoEventos entity = this.repository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Solicitação de evento com id= %s não encontrada", id))
        );
        if (dto.getDescricao() != null) entity.setDescricao(dto.getDescricao());
        if (dto.getComentarios() != null) entity.setComentarios(dto.getComentarios());
        if (dto.getBairro() != null) entity.setBairro(dto.getBairro());
        if (dto.getNomeRua() != null) entity.setNomeRua(dto.getNomeRua());
        if (dto.getLocal() != null) entity.setLocal(dto.getLocal());
        if (dto.getDataEvento() != null) entity.setDataEvento(dto.getDataEvento());
        if (dto.getTipoEvento() != null) entity.setTipoEvento(dto.getTipoEvento());
        entity = this.repository.save(entity);
        return SolicitacaoEventosMapper.toDto(entity);
    }

    @Transactional
    public void delete(Long id) {
        SolicitacaoEventos entity = repository.getById(id);
        repository.delete(entity);
    }
}

