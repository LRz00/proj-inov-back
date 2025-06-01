package com.ifba.proj_inov.core.repository;

import com.ifba.proj_inov.core.entities.Usuarios;
import com.ifba.proj_inov.core.repository.projection.UsuariosProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {

    Optional<Usuarios> findByEmail(String email);
    Optional<Usuarios> findByCpf(String cpf);
    @Query("select x from Usuarios x")
    Page<UsuariosProjection> findAllPageable(Pageable pageable);

}
