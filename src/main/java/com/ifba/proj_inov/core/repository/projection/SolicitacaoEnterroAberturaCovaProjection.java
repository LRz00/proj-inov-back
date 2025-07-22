package com.ifba.proj_inov.core.repository.projection;

import com.ifba.proj_inov.core.entitites.Usuario;
import com.ifba.proj_inov.core.entitites.enums.SolicitacaoStatusEnum;

public interface SolicitacaoEnterroAberturaCovaProjection {
    Long getId();
    String getDescricao();
    String getDataCriada();
    SolicitacaoStatusEnum getStatus();
    Usuario getSolicitante();
    String getComentarios();
    String getBairro();
    String getNomeRua();
}
