package com.ifba.proj_inov.core.repository;

import com.ifba.proj_inov.core.entitites.Usuario;
import com.ifba.proj_inov.core.repository.projection.UsuariosProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsuariosRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);
    Optional<Usuario> findByCpf(String cpf);
    @Query("select x from Usuario x")
    Page<UsuariosProjection> findAllPageable(Pageable pageable);

}
