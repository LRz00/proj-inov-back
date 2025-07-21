package com.ifba.proj_inov.api.dto;

import com.ifba.proj_inov.core.entitites.Usuario;
import com.ifba.proj_inov.core.entitites.enums.SolicitacaoStatusEnum;
import java.time.LocalDateTime;

public class SolicitacaoEventosResponseDto {
    private Long id;
    private String descricao;
    private String dataCriada;
    private SolicitacaoStatusEnum status;
    private Usuario solicitante;
    private String comentarios;
    private String bairro;
    private String nomeRua;
    private String local;
    private LocalDateTime dataEvento;
    private String tipoEvento;

    public SolicitacaoEventosResponseDto() {}

    // Getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public String getDataCriada() { return dataCriada; }
    public void setDataCriada(String dataCriada) { this.dataCriada = dataCriada; }
    public SolicitacaoStatusEnum getStatus() { return status; }
    public void setStatus(SolicitacaoStatusEnum status) { this.status = status; }
    public Usuario getSolicitante() { return solicitante; }
    public void setSolicitante(Usuario solicitante) { this.solicitante = solicitante; }
    public String getComentarios() { return comentarios; }
    public void setComentarios(String comentarios) { this.comentarios = comentarios; }
    public String getBairro() { return bairro; }
    public void setBairro(String bairro) { this.bairro = bairro; }
    public String getNomeRua() { return nomeRua; }
    public void setNomeRua(String nomeRua) { this.nomeRua = nomeRua; }
    public String getLocal() { return local; }
    public void setLocal(String local) { this.local = local; }
    public LocalDateTime getDataEvento() { return dataEvento; }
    public void setDataEvento(LocalDateTime dataEvento) { this.dataEvento = dataEvento; }
    public String getTipoEvento() { return tipoEvento; }
    public void setTipoEvento(String tipoEvento) { this.tipoEvento = tipoEvento; }
}

