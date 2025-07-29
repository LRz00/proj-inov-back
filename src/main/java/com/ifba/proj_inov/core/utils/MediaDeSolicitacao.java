package com.ifba.proj_inov.core.utils;

import com.ifba.proj_inov.core.entitites.Solicitacao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MediaDeSolicitacao {

    public Double calcularMediaGeral(List<? extends Solicitacao> solicitacoes) {
        if (solicitacoes == null || solicitacoes.isEmpty()) {
            return 0.0;
        }

        double somaTotal = 0.0;
        int quantidadeNotas = 0;

        for (Solicitacao solicitacao : solicitacoes) {
            if (solicitacao.getNotas() != null && !solicitacao.getNotas().isEmpty()) {
                somaTotal += solicitacao.calcularMedia() * solicitacao.getNotas().size();
                quantidadeNotas += solicitacao.getNotas().size();
            }
        }

        return quantidadeNotas > 0 ? somaTotal / quantidadeNotas : 0.0;
    }
}
