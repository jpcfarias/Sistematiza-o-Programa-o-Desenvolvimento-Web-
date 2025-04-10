package com.healthcare.controller;

import com.healthcare.model.Profissional;
import com.healthcare.service.ProfissionalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/profissionais")
@Tag(name = "Profissionais de Saúde", description = "API para gerenciamento de profissionais de saúde")
public class ProfissionalController {
    private final ProfissionalService profissionalService;

    public ProfissionalController(ProfissionalService profissionalService) {
        this.profissionalService = profissionalService;
    }

    @GetMapping
    @Operation(summary = "Listar todos os profissionais", description = "Retorna uma lista com todos os profissionais de saúde cadastrados")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de profissionais retornada com sucesso")
    })
    public ResponseEntity<List<Profissional>> listarTodos() {
        return ResponseEntity.ok(profissionalService.buscarTodos());
    }

    @GetMapping("/especialidade/{especialidade}")
    @Operation(summary = "Buscar profissionais por especialidade", description = "Retorna uma lista de profissionais filtrada por especialidade")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de profissionais retornada com sucesso"),
        @ApiResponse(responseCode = "404", description = "Nenhum profissional encontrado para a especialidade especificada")
    })
    public ResponseEntity<List<Profissional>> buscarPorEspecialidade(
            @Parameter(description = "Especialidade dos profissionais", example = "Cardiologia")
            @PathVariable String especialidade) {
        return ResponseEntity.ok(profissionalService.buscarPorEspecialidade(especialidade));
    }

    @GetMapping("/busca")
    @Operation(summary = "Buscar profissionais por nome", description = "Retorna uma lista de profissionais filtrada por nome")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de profissionais retornada com sucesso"),
        @ApiResponse(responseCode = "404", description = "Nenhum profissional encontrado com o nome especificado")
    })
    public ResponseEntity<List<Profissional>> buscarPorNome(
            @Parameter(description = "Nome ou parte do nome do profissional", example = "João")
            @RequestParam String nome) {
        return ResponseEntity.ok(profissionalService.buscarPorNome(nome));
    }

    @GetMapping("/especialidades")
    @Operation(summary = "Listar todas as especialidades", description = "Retorna uma lista com todas as especialidades disponíveis")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de especialidades retornada com sucesso")
    })
    public ResponseEntity<List<String>> listarEspecialidades() {
        return ResponseEntity.ok(profissionalService.listarEspecialidades());
    }
} 