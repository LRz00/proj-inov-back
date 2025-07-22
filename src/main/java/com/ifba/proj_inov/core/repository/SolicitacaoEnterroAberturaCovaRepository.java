package com.ifba.proj_inov.core.repository;

import com.ifba.proj_inov.core.entitites.SolicitacaoEnterroAberturaCova;
import com.ifba.proj_inov.core.repository.projection.SolicitacaoEnterroAberturaCovaProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitacaoEnterroAberturaCovaRepository extends JpaRepository<SolicitacaoEnterroAberturaCova, Long> {
    @Query("SELECT s FROM Solicitacao s WHERE TYPE(s) = SolicitacaoEnterroAberturaCova ")
    Page<SolicitacaoEnterroAberturaCovaProjection> findAllPageable(Pageable pageable);
}
