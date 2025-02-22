package com.inditex.pruebatecnica.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * The type Price input dto.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PriceInputDto {

    /**
     * The Product id.
     */
    @Schema(example = "35455", description = "Identificador codigo de producto")
    @NotNull(message = "El ID del producto no puede ser nulo")
    @Min(value = 1, message = "El ID del producto debe ser mayor a 0")
    private Integer productId;

    /**
     * The Brand id.
     */
    @Schema(example = "1", description = "Cadena del grupo (1 = ZARA)")
    @NotNull(message = "El ID de la marca no puede ser nulo")
    @Min(value = 1, message = "El ID de la marca debe ser mayor a 0")
    private Integer brandId;
    /**
     * The Date.
     */
    @Schema(example = "2025-02-20 12:30", description = "Fecha de aplicacion")
    @NotNull(message = "La fecha de aplicación no puede ser nula")
    private LocalDateTime date;
}
