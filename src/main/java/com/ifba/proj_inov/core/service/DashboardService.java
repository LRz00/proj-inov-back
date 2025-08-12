package com.ifba.proj_inov.core.service;

import com.ifba.proj_inov.core.entitites.Solicitacao;
import com.ifba.proj_inov.core.entitites.enums.SolicitacaoStatusEnum;
import com.ifba.proj_inov.core.repository.*;
import com.ifba.proj_inov.core.service.enums.TipoSolicitacao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DashboardService {

    public final SolicitacaoEventosRepository eventosRepository;
    public final SolicitacaoManIluminacaoPublicaRepository iluminacaoRepository;
    public final SolicitacaoManViaPublicaRepository viaPublicaRepository;
    public final SolicitacaoPlantioArvoreRepository plantioRepository;
    public final SolicitacaoRemocaoArvoreCaidaRepository remocaoArvoreCaidaRepository;
    public final DenunciaRepository denunciaRepository;
    private final UsuariosRepository usuariosRepository;
    private final SolicitacaoRepository solicitacaoRepository;

    public DashboardService(SolicitacaoEventosRepository eventosRepository, SolicitacaoManIluminacaoPublicaRepository iluminacaoRepository, SolicitacaoManViaPublicaRepository viaPublicaRepository, SolicitacaoPlantioArvoreRepository plantioRepository, SolicitacaoRemocaoArvoreCaidaRepository remocaoArvoreCaidaRepository, DenunciaRepository denunciaRepository, UsuariosRepository usuariosRepository, SolicitacaoRepository solicitacaoRepository) {
        this.eventosRepository = eventosRepository;
        this.iluminacaoRepository = iluminacaoRepository;
        this.viaPublicaRepository = viaPublicaRepository;
        this.plantioRepository = plantioRepository;
        this.remocaoArvoreCaidaRepository = remocaoArvoreCaidaRepository;
        this.denunciaRepository = denunciaRepository;
        this.usuariosRepository = usuariosRepository;
        this.solicitacaoRepository = solicitacaoRepository;
    }

    @Transactional(readOnly = true)
    public long getTotalSolicitacoes(){

        return (eventosRepository.count() +
                iluminacaoRepository.count() +
                viaPublicaRepository.count() +
                plantioRepository.count() +
                remocaoArvoreCaidaRepository.count() +
                denunciaRepository.count());
    }

    @Transactional(readOnly = true)
    public long getTotalUsuarios(){
        return usuariosRepository.count();
    }

    @Transactional(readOnly = true)
    public long getNumSolicitacoesPorTipo(TipoSolicitacao tipo) {
        return tipo.getCount(this);
    }

    @Transactional(readOnly = true)
    public Map<SolicitacaoStatusEnum, Long> getNumSolicitacoesPorStatus(){
        Map<SolicitacaoStatusEnum, Long> contagem = new HashMap<>();

        for (SolicitacaoStatusEnum status : SolicitacaoStatusEnum.values()) {
            long quantidade = solicitacaoRepository.countByStatus(status);
            contagem.put(status, quantidade);
        }

        return contagem;
    }

    @Transactional(readOnly = true)
    public Map<SolicitacaoStatusEnum, Double> getPorcentagemStatus() {
        Map<SolicitacaoStatusEnum, Double> porcentagens = new HashMap<>();

        long totalSolicitacoes = solicitacaoRepository.count();

        if (totalSolicitacoes == 0) {
            for (SolicitacaoStatusEnum status : SolicitacaoStatusEnum.values()) {
                porcentagens.put(status, 0.0);
            }
            return porcentagens;
        }

        for (SolicitacaoStatusEnum status : SolicitacaoStatusEnum.values()) {
            long count = solicitacaoRepository.countByStatus(status);
            double porcentagem = (count * 100.0) / totalSolicitacoes;
            porcentagens.put(status, porcentagem);
        }

        return porcentagens;
    }

    @Transactional(readOnly = true)
    public Map<TipoSolicitacao, Double> getTempoMedioConclusaoPorTipo() {
        Map<TipoSolicitacao, Double> medias = new HashMap<>();

        medias.put(TipoSolicitacao.EVENTOS,
                calcularMediaDias(eventosRepository.findAll()));
        medias.put(TipoSolicitacao.ILUMINACAO,
                calcularMediaDias(iluminacaoRepository.findAll()));
        medias.put(TipoSolicitacao.VIA_PUBLICA,
                calcularMediaDias(viaPublicaRepository.findAll()));
        medias.put(TipoSolicitacao.PLANTIO,
                calcularMediaDias(plantioRepository.findAll()));
        medias.put(TipoSolicitacao.REMOCAO_ARVORE,
                calcularMediaDias(remocaoArvoreCaidaRepository.findAll()));
        medias.put(TipoSolicitacao.DENUNCIA,
                calcularMediaDias(denunciaRepository.findAll()));

        return medias;
    }

    private double calcularMediaDias(List<? extends Solicitacao> solicitacoes) {
        var concluidas = solicitacoes.stream()
                .filter(s -> s.getStatus() == SolicitacaoStatusEnum.CONCLUIDA
                        && s.getDataCriada() != null
                        && s.getDataConcluida() != null)
                .toList();

        if (concluidas.isEmpty()) {
            return 0.0;
        }

        double somaDias = concluidas.stream()
                .mapToDouble(s -> {
                    LocalDate criada = LocalDate.parse(s.getDataCriada());
                    LocalDate concluida = LocalDate.parse(s.getDataConcluida());
                    return ChronoUnit.DAYS.between(criada, concluida);
                })
                .sum();

        return somaDias / concluidas.size();
    }
}
