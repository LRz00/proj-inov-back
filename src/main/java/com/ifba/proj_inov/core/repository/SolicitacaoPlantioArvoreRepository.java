package com.ifba.proj_inov.core.repository;

import com.ifba.proj_inov.core.entitites.SolicitacaoPlantioArvore;
import com.ifba.proj_inov.core.repository.projection.SolicitacaoPlantioArvoreProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitacaoPlantioArvoreRepository extends JpaRepository<SolicitacaoPlantioArvore, Long> {
    @Query("SELECT s FROM Solicitacao s WHERE TYPE(s) = SolicitacaoPlantioArvore")
    Page<SolicitacaoPlantioArvoreProjection> findAllPageable(Pageable pageable);
}
