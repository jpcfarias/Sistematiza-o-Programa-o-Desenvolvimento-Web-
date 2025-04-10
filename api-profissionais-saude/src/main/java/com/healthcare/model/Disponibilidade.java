package com.healthcare.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Schema(description = "Representa um período de disponibilidade de um profissional")
public class Disponibilidade {
    @Schema(description = "Data e hora de início da disponibilidade")
    private LocalDateTime inicio;
    
    @Schema(description = "Data e hora de fim da disponibilidade")
    private LocalDateTime fim;
    
    @Schema(description = "Indica se o profissional está disponível neste período")
    private boolean disponivel;
} 