package com.ifba.proj_inov.core.repository;

import com.ifba.proj_inov.core.entitites.Solicitacao;
import com.ifba.proj_inov.core.repository.projection.SolicitacoesProjection;
import com.ifba.proj_inov.core.repository.projection.UsuariosProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitacoesRepository extends JpaRepository<Solicitacao, Long> {

    @Query("SELECT s FROM Solicitacao s")
    Page<SolicitacoesProjection> findAllPageable(Pageable pageable);

}
