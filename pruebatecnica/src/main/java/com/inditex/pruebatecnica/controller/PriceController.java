package com.inditex.pruebatecnica.controller;

import com.inditex.pruebatecnica.model.dto.PriceInputDto;
import com.inditex.pruebatecnica.model.dto.PriceOutputDto;
import com.inditex.pruebatecnica.service.impl.PriceServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * The type Price controller.
 */
@RestController
@RequestMapping("/prices")
@Validated
public class PriceController {

    private final PriceServiceImpl priceService;

    /**
     * Instantiates a new Price controller.
     *
     * @param priceService the price service
     */
    public PriceController(PriceServiceImpl priceService) {
        this.priceService = priceService;
    }

    /**
     * Find product data response entity.
     *
     * @param dto the dto
     * @return the response entity
     */
    @Operation(summary = "as", description = "as")
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @PostMapping(value = "/producData", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PriceOutputDto> findProductData(
            @Valid @RequestBody PriceInputDto dto) {

        PriceOutputDto result = priceService.findProductData(dto);
        return new ResponseEntity<>(result, HttpStatusCode.valueOf(200));
    }
}
