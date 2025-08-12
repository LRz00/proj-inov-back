package com.ifba.proj_inov.core.entitites;

import com.ifba.proj_inov.core.entitites.enums.DenunciaEnum;
import com.ifba.proj_inov.core.entitites.enums.PrioridadeEnum;
import com.ifba.proj_inov.core.entitites.enums.SolicitacaoStatusEnum;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.List;

@Entity
public class Denuncia extends Solicitacao {

    @Column(name = "prioridade")
    private PrioridadeEnum prioridade;

    @Column(name = "tipo_denuncia")
    private DenunciaEnum denuncia;

    public Denuncia() {
    }

    public Denuncia(PrioridadeEnum prioridade, DenunciaEnum denuncia) {
        this.prioridade = prioridade;
        this.denuncia = denuncia;
    }

    public Denuncia(Long id, String descricao, String dataCriada, String dataConcluida, SolicitacaoStatusEnum status, Usuario solicitante, String comentarios, List<Double> notas, PrioridadeEnum prioridade, DenunciaEnum denuncia) {
        super(id, descricao, dataCriada, dataConcluida, status, solicitante, comentarios, notas);
        this.prioridade = prioridade;
        this.denuncia = denuncia;
    }

    public PrioridadeEnum getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(PrioridadeEnum prioridade) {
        this.prioridade = prioridade;
    }

    public DenunciaEnum getDenuncia() {
        return denuncia;
    }

    public void setDenuncia(DenunciaEnum denuncia) {
        this.denuncia = denuncia;
    }

}
