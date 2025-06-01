package com.ifba.proj_inov.Paciente.service;

import com.ifba.proj_inov.Paciente.entity.Paciente;
import com.ifba.proj_inov.Paciente.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PacienteService implements PacienteIService {

    private final PacienteRepository pacienteRepository;

    // Método para buscar todos os Pacientes com suporte à paginação
    @Override
    public Page<Paciente> findAll(Pageable pageable) {
        return pacienteRepository.findAll(pageable); }

    // Método para buscar Pacientes pelo nome
    @Override
    public List<Paciente> findByNomeCompleto(String nomeCompleto) {
        return pacienteRepository.findByNomeCompleto(nomeCompleto); }

    // Método para buscar um único Paciente pelo ID
    @Override
    public Paciente findById(Long id) {
        return pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado!"));
    }

    // Método para salvar um novo Paciente ou atualizar um existente, em uma transação
    @Override
    @Transactional
    public Paciente save(Paciente paciente) {
        return pacienteRepository.save(paciente);}

    // Método para atualizar um paciente existente
    @Override
    @Transactional
    public void update(Paciente paciente) {
        pacienteRepository.save(paciente);
    }

    // Método para deletar um Paciente com base no ID
    @Override
    public Map<String, String> delete(Long id) {
        pacienteRepository.deleteById(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Paciente deletado com sucesso");
        return response;
    }


}
