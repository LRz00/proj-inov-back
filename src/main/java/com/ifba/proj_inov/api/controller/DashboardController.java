package com.ifba.proj_inov.api.controller;

import com.ifba.proj_inov.core.entitites.enums.SolicitacaoStatusEnum;
import com.ifba.proj_inov.core.service.DashboardService;
import com.ifba.proj_inov.core.service.enums.TipoSolicitacao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    private final DashboardService service;

    public DashboardController(DashboardService service) {
        this.service = service;
    }

    @GetMapping("/total-solicitacoes")
    public ResponseEntity<Long> getTotalSolicitacoes(){
        Long total = service.getTotalSolicitacoes();

        return ResponseEntity.ok(total);
    }

    @GetMapping("/total-usuarios")
    public ResponseEntity<Long> getTotalUsuarios(){
        Long total = service.getTotalUsuarios();

        return ResponseEntity.ok(total);
    }

    @GetMapping("/solicitacoes/{tipo}")
    public ResponseEntity<Long> getCountByTipo(@PathVariable String tipo) {
        try {
            TipoSolicitacao tipoEnum = TipoSolicitacao.valueOf(tipo.toUpperCase());
            return ResponseEntity.ok(service.getNumSolicitacoesPorTipo(tipoEnum));

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(0L); // Tipo inválido
        }
    }

    @GetMapping("/porcentagem-status")
    public ResponseEntity<Map<SolicitacaoStatusEnum, Double>> getPorcentagemStatus() {
        return ResponseEntity.ok(service.getPorcentagemStatus());
    }

    @GetMapping("/contagem-status")
    public ResponseEntity<Map<SolicitacaoStatusEnum, Long>> getContagemStatus() {
        return ResponseEntity.ok(service.getNumSolicitacoesPorStatus());
    }

    @GetMapping("/tempo-medio-conclusao")
    public Map<TipoSolicitacao, Double> getTempoMedioConclusao() {
        return service.getTempoMedioConclusaoPorTipo();
    }
}
