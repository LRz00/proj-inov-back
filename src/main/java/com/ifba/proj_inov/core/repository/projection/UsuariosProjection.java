package com.ifba.proj_inov.core.repository.projection;

import jakarta.persistence.Column;

public interface UsuariosProjection {
    Long getId();
    String getNome();
    String getSexo();
    String getCpf();
    String getEmail();
}
