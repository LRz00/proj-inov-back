package com.ifba.proj_inov.core.service;

import com.ifba.proj_inov.core.entitites.Usuario;
import com.ifba.proj_inov.core.repository.UsuariosRepository;
import com.ifba.proj_inov.core.repository.projection.UsuariosProjection;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
public class UsuariosService {

    private final UsuariosRepository usuariosRepository;

    public UsuariosService(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Usuario salvar(Usuario usuario) {
        Optional<Usuario> usuariosOptionalEmail = this.usuariosRepository.findByEmail(usuario.getEmail());
        Optional<Usuario> usuariosOptionalCpf = this.usuariosRepository.findByCpf(usuario.getCpf());
        if (usuariosOptionalEmail.isPresent()) {
            throw new RuntimeException("Email já está em uso");
        }
        if (usuariosOptionalCpf.isPresent()) {
            throw new RuntimeException("CPF já está em uso");
        }
        if (usuario.getCpf().isBlank() || usuario.getEmail().isBlank() || usuario.getSenha().isBlank()) {
            throw new RuntimeException("Informação inválida");
        }

        return this.usuariosRepository.save(usuario);
    }

    @Transactional(readOnly = true)
    public Usuario getById(Long id) {
        return usuariosRepository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Usuário com id= %s não encontrado", id))
        );
    }

    @Transactional(readOnly = true)
    public Usuario getByCpf(String cpf) {
        return usuariosRepository.findByCpf(cpf).orElseThrow(
                () -> new RuntimeException(String.format("Usuário com CPF= %s não encontrado", cpf))
        );
    }

        @Transactional(readOnly = true)
    public Usuario getByEmail(String email) {
        return usuariosRepository.findByEmail(email).orElseThrow(
                () -> new RuntimeException(String.format("Usuário com email= %s não encontrado", email))
        );
    }


    @Transactional(readOnly = true)
    public Page<UsuariosProjection> getAll(Pageable pageable) {
        return usuariosRepository.findAllPageable(pageable);
    }

    @Transactional
    public void delete(Long id) {
        Usuario usuario = getById(id);
        usuariosRepository.delete(usuario);
    }
}
