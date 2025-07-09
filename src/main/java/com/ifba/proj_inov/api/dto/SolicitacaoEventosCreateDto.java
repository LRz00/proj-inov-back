package com.ifba.proj_inov.api.dto;

import com.ifba.proj_inov.core.entitites.Usuario;
import com.ifba.proj_inov.core.entitites.enums.SolicitacaoStatusEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class SolicitacaoEventosCreateDto {
    @NotBlank
    private String descricao;

    @NotBlank
    private String dataCriada;

    private SolicitacaoStatusEnum status;

    @NotNull
    private Usuario solicitante;

    @NotBlank
    private String bairro;

    @NotBlank
    private String nomeRua;

    @NotBlank
    private String local;

    @NotNull
    private LocalDateTime dataEvento;

    @NotBlank
    private String tipoEvento;

    public SolicitacaoEventosCreateDto() {}

    // Getters e setters
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public String getDataCriada() { return dataCriada; }
    public void setDataCriada(String dataCriada) { this.dataCriada = dataCriada; }
    public SolicitacaoStatusEnum getStatus() { return status; }
    public void setStatus(SolicitacaoStatusEnum status) { this.status = status; }
    public Usuario getSolicitante() { return solicitante; }
    public void setSolicitante(Usuario solicitante) { this.solicitante = solicitante; }
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

