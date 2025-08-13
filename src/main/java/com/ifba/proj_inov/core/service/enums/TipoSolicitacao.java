package com.ifba.proj_inov.core.service.enums;

import com.ifba.proj_inov.core.service.DashboardService;

import java.util.function.ToLongFunction;

public enum TipoSolicitacao {
    EVENTOS(service -> service.eventosRepository.count()),
    ILUMINACAO(service -> service.iluminacaoRepository.count()),
    VIA_PUBLICA(service -> service.viaPublicaRepository.count()),
    PLANTIO(service -> service.plantioRepository.count()),
    REMOCAO_ARVORE(service -> service.remocaoArvoreCaidaRepository.count()),
    DENUNCIA(service -> service.denunciaRepository.count()),
    COVAS(service -> service.covaRepository.count()),
    CAPINACAO(service -> service.capinacaoRepository.count()),
    VISTORIA(service -> service.vistoriaRepository.count());

    private final ToLongFunction<DashboardService> counter;

    TipoSolicitacao(ToLongFunction<DashboardService> counter) {
        this.counter = counter;
    }

    public long getCount(DashboardService service) {
        return counter.applyAsLong(service);
    }
}
