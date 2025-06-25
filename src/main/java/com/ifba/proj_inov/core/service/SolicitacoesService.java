package com.ifba.proj_inov.core.service;

import com.ifba.proj_inov.api.dto.SolicitacoesUpdateDto;
import com.ifba.proj_inov.core.entitites.Solicitacao;
import com.ifba.proj_inov.core.entitites.Usuario;
import com.ifba.proj_inov.core.entitites.enums.SolicitacaoStatusEnum;
import com.ifba.proj_inov.core.repository.SolicitacoesRepository;
import com.ifba.proj_inov.core.repository.projection.SolicitacoesProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SolicitacoesService {

    private final SolicitacoesRepository solicitacoesRepository;

    @Autowired
    public SolicitacoesService(SolicitacoesRepository solicitacoesRepository) {
        this.solicitacoesRepository = solicitacoesRepository;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Solicitacao salvar(Solicitacao solicitacao) {
        solicitacao.setStatus(SolicitacaoStatusEnum.ABERTA);
        return this.solicitacoesRepository.save(solicitacao);
    }

    @Transactional(readOnly = true)
    public Solicitacao getById(Long id) {
        return this.solicitacoesRepository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Solicitação com id= %s não encontrado", id))
        );
    }

    @Transactional(readOnly = true)
    public Page<SolicitacoesProjection> getAll(Pageable pageable) {
        return this.solicitacoesRepository.findAllPageable(pageable);
    }

    @Transactional
    public Solicitacao update(SolicitacoesUpdateDto dto, Long id) {
        Solicitacao solicitacao = solicitacoesRepository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Solicitação com id= %s não encontrado", id))
        );

        if (dto.getDescricao() != null) {
            solicitacao.setDescricao(dto.getDescricao());
        }

        if (dto.getComentarios() != null) {
            solicitacao.setComentarios(dto.getComentarios());
        }

        return solicitacoesRepository.save(solicitacao);
    }

    @Transactional
    public void delete(Long id) {
        Solicitacao solicitacao = solicitacoesRepository.getById(id);
        solicitacoesRepository.delete(solicitacao);
    }

}
