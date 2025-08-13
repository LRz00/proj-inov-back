package com.ifba.proj_inov.core.repository.projection;

import com.ifba.proj_inov.core.entitites.Usuario;
import com.ifba.proj_inov.core.entitites.enums.DenunciaEnum;
import com.ifba.proj_inov.core.entitites.enums.PrioridadeEnum;
import com.ifba.proj_inov.core.entitites.enums.SolicitacaoStatusEnum;

public interface DenunciaProjection {
    Long getId();
    String getDescricao();
    String getDataCriada();
    SolicitacaoStatusEnum getStatus();
    Usuario getSolicitante();
    String getComentarios();
    PrioridadeEnum getPrioridade();
    DenunciaEnum getDenuncia();
    String getDataConcluida();
}
