package com.ifba.proj_inov.core.repository;

import com.ifba.proj_inov.core.entitites.Solicitacao;
import com.ifba.proj_inov.core.entitites.enums.SolicitacaoStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long> {
    long countByStatus(SolicitacaoStatusEnum status);
}
