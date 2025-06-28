package com.ifba.proj_inov.core.repository;

import com.ifba.proj_inov.core.entitites.SolicitacaoRemocaoArvoreCaida;
import com.ifba.proj_inov.core.repository.projection.SolicitacaoManViaPublicaProjection;
import com.ifba.proj_inov.core.repository.projection.SolicitacaoRemocaoArvoreCaidaProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitacaoRemocaoArvoreCaidaRepository extends JpaRepository<SolicitacaoRemocaoArvoreCaida, Long> {

    @Query("SELECT s FROM Solicitacao s WHERE TYPE(s) = SolicitacaoRemocaoArvoreCaida")
    Page<SolicitacaoRemocaoArvoreCaidaProjection> findAllPageable(Pageable pageable);

}
