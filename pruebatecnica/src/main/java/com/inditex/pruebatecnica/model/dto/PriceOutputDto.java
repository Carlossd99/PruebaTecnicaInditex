package com.inditex.pruebatecnica.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * The type Price output dto.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PriceOutputDto {

    /**
     * The Brand id.
     */
    @Schema(example = "1", description = "cadena del grupo (1 = ZARA)")
    private Integer brandId;
    /**
     * The Start date.
     */
    @Schema(example = "2020-06-14-00.00.00", description = "fecha inicial de aplicacion de tarifa")
    private LocalDateTime startDate;
    /**
     * The End date.
     */
    @Schema(example = "2020-06-14-00.00.00", description = "fecha final de aplicacion de tarifa")
    private LocalDateTime endDate;
    /**
     * The Price list.
     */
    @Schema(example = "1", description = "Identificador de la tarifa de precios aplicable")
    private Integer priceList;
    /**
     * The Product id.
     */
    @Schema(example = "35455", description = "Identificador código de producto")
    private Integer productId;
    /**
     * The Priority.
     */
    @Schema(example = "0", description = "Desambiguador de aplicación de precios")
    private Integer priority;
    /**
     * The Price.
     */
    @Schema(example = "35.50", description = "Precio final de venta")
    private BigDecimal price;
    /**
     * The Curr.
     */
    @Schema(example = "EUR", description = "iso de la moneda")
    private String curr;
}
