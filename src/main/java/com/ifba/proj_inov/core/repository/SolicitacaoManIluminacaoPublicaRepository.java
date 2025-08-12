package com.ifba.proj_inov.core.repository;

import com.ifba.proj_inov.core.entitites.SolicitacaoManIluminacaoPublica;
import com.ifba.proj_inov.core.entitites.SolicitacaoManViaPublica;
import com.ifba.proj_inov.core.repository.projection.SolicitacaoManIluminacaoPublicaProjection;
import com.ifba.proj_inov.core.repository.projection.SolicitacaoManViaPublicaProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitacaoManIluminacaoPublicaRepository
        extends JpaRepository<SolicitacaoManIluminacaoPublica, Long> {

    @Query("SELECT s FROM SolicitacaoManIluminacaoPublica s")
    Page<SolicitacaoManIluminacaoPublicaProjection> findAllPageable(Pageable pageable);

}
