package com.ifba.proj_inov.core.repository;

import com.ifba.proj_inov.core.entities.Usuarios;
import com.ifba.proj_inov.core.repository.projection.UserDetailsProjection;
import com.ifba.proj_inov.core.repository.projection.UsuariosProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {

    @Query(nativeQuery = true, value = """
				SELECT tb_user.email AS username, tb_user.password, tb_role.id AS roleId, tb_role.authority
				FROM tb_user
				INNER JOIN tb_user_role ON tb_user.id = tb_user_role.user_id
				INNER JOIN tb_role ON tb_role.id = tb_user_role.role_id
				WHERE tb_user.email = :email
			""")
    List<UserDetailsProjection> searchUserAndRolesByEmail(String email);
    Optional<Usuarios> findByEmail(String email);
    Optional<Usuarios> findByCpf(String cpf);
    @Query("select x from Usuarios x")
    Page<UsuariosProjection> findAllPageable(Pageable pageable);

}
