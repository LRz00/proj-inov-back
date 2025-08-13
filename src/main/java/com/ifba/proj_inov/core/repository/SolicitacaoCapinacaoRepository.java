package com.ifba.proj_inov.core.repository;

import com.ifba.proj_inov.core.entitites.SolicitacaoCapinacao;
import com.ifba.proj_inov.core.repository.projection.SolicitacaoCapinacaoProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SolicitacaoCapinacaoRepository extends JpaRepository<SolicitacaoCapinacao, Long> {

    @Query("SELECT s FROM Solicitacao s WHERE TYPE(s) = SolicitacaoCapinacao")
    Page<SolicitacaoCapinacaoProjection> findAllPageable(Pageable pageable);
}
