package com.ifba.proj_inov.core.entitites;

import com.ifba.proj_inov.core.entitites.enums.DenunciaEnum;
import com.ifba.proj_inov.core.entitites.enums.PrioridadeEnum;
import com.ifba.proj_inov.core.entitites.enums.SolicitacaoStatusEnum;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
public class Denuncia extends Solicitacao {

    @Column(name = "prioridade")
    private PrioridadeEnum prioridade;

    @Column(name = "tipo_denuncia")
    private DenunciaEnum denuncia;

    @Column(name = "data_concluida")
    private String dataConcluida;

    public Denuncia() {
    }

    public Denuncia(PrioridadeEnum prioridade, DenunciaEnum denuncia, String dataConcluida) {
        this.prioridade = prioridade;
        this.denuncia = denuncia;
        this.dataConcluida = dataConcluida;
    }

    public Denuncia(Long id, String descricao, String dataCriada, SolicitacaoStatusEnum status, Usuario solicitante, String comentarios, PrioridadeEnum prioridade, DenunciaEnum denuncia, String dataConcluida) {
        super(id, descricao, dataCriada, status, solicitante, comentarios);
        this.prioridade = prioridade;
        this.denuncia = denuncia;
        this.dataConcluida = dataConcluida;
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

    public String getDataConcluida() {
        return dataConcluida;
    }

    public void setDataConcluida(String dataConcluida) {
        this.dataConcluida = dataConcluida;
    }
}
