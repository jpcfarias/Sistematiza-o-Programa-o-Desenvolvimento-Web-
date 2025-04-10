package com.healthcare.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@Schema(description = "Representa um profissional de saúde")
public class Profissional {
    @Schema(description = "Identificador único do profissional")
    private String id;
    
    @Schema(description = "Nome completo do profissional")
    private String nome;
    
    @Schema(description = "Especialidade do profissional")
    private String especialidade;
    
    @Schema(description = "Lista de disponibilidades do profissional")
    private List<Disponibilidade> disponibilidades;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public List<Disponibilidade> getDisponibilidades() {
        return disponibilidades;
    }

    public void setDisponibilidades(List<Disponibilidade> disponibilidades) {
        this.disponibilidades = disponibilidades;
    }
} 