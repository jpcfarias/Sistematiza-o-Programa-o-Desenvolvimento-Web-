package com.healthcare.service;

import com.healthcare.model.Profissional;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Service;
import org.springframework.core.io.ClassPathResource;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfissionalService {
    private List<Profissional> profissionais;
    private final ObjectMapper objectMapper;

    public ProfissionalService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        carregarDados();
    }

    private void carregarDados() {
        try {
            ClassPathResource resource = new ClassPathResource("data/profissionais.json");
            profissionais = objectMapper.readValue(resource.getInputStream(),
                    new TypeReference<List<Profissional>>() {});
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar dados dos profissionais", e);
        }
    }

    public List<Profissional> buscarTodos() {
        return profissionais;
    }

    public List<Profissional> buscarPorEspecialidade(String especialidade) {
        return profissionais.stream()
                .filter(p -> p.getEspecialidade().equalsIgnoreCase(especialidade))
                .collect(Collectors.toList());
    }

    public List<Profissional> buscarPorNome(String nome) {
        return profissionais.stream()
                .filter(p -> p.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<String> listarEspecialidades() {
        return profissionais.stream()
                .map(Profissional::getEspecialidade)
                .distinct()
                .collect(Collectors.toList());
    }
} 