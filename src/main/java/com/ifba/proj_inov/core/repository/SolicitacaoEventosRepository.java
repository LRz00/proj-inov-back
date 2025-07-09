package com.ifba.proj_inov.core.repository;

import com.ifba.proj_inov.core.entitites.SolicitacaoEventos;
import com.ifba.proj_inov.core.repository.projection.SolicitacaoEventosProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitacaoEventosRepository extends JpaRepository<SolicitacaoEventos, Long> {
    @Query("SELECT s FROM SolicitacaoEventos s")
    Page<SolicitacaoEventosProjection> findAllPageable(Pageable pageable);
}

