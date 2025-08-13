package com.ifba.proj_inov.core.repository;

import com.ifba.proj_inov.core.entitites.SolicitacaoVistoria;
import com.ifba.proj_inov.core.repository.projection.SolicitacaoVistoriaProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitacaoVistoriaRepository  extends JpaRepository<SolicitacaoVistoria, Long> {
    @Query("SELECT s FROM Solicitacao s WHERE TYPE(s) = SolicitacaoVistoria ")
    Page<SolicitacaoVistoriaProjection> findAllPageable(Pageable pageable);
}
