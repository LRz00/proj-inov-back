package com.ifba.proj_inov.core.service;

import com.ifba.proj_inov.core.entities.Usuarios;
import com.ifba.proj_inov.core.exception.EntityNotFoundException;
import com.ifba.proj_inov.core.exception.InvalidRegistrationInformationException;
import com.ifba.proj_inov.core.exception.UserAlreadyExistsException;
import com.ifba.proj_inov.core.repository.UsuariosRepository;
import com.ifba.proj_inov.core.repository.projection.UsuariosProjection;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
public class UsuariosService {

    private final UsuariosRepository usuariosRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuariosService(UsuariosRepository usuariosRepository, PasswordEncoder passwordEncoder) {
        this.usuariosRepository = usuariosRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Usuarios salvar(Usuarios usuario){

        Optional<Usuarios> usuariosOptional = this.usuariosRepository.findByEmail(usuario.getEmail());
        if(usuariosOptional.isPresent()){
            throw new UserAlreadyExistsException("Email já está em uso");
        }
        if(usuario.getCpf().isBlank() || usuario.getEmail().isBlank() || usuario.getSenha().isBlank()){
            throw new InvalidRegistrationInformationException("Informação inválida");
        }

        usuario.setSenha(this.passwordEncoder.encode(usuario.getSenha()));

        Usuarios usuarioEntidade = this.usuariosRepository.save(usuario);


        return usuarioEntidade;
    }

    @Transactional(readOnly = true)
    public Usuarios getById(Long id){
        return usuariosRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Usuário com id= %s não encontrado", id))
        );
    }

    @Transactional(readOnly = true)
    public Usuarios getByCpf(String cpf){
        return usuariosRepository.findByCpf(cpf).orElseThrow(
                () -> new EntityNotFoundException(String.format("Usuário com id= %s não encontrado", cpf))
        );
    }

    @Transactional(readOnly = true)
    public Page<UsuariosProjection> getAll(Pageable pageable){
        Page<UsuariosProjection> usuarios = usuariosRepository.findAllPageable(pageable);

        return usuarios;
    }

    @Transactional
    public void delete(Long id){
        Usuarios usuario = getById(id);
    }

}
