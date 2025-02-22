package com.inditex.pruebatecnica.service;


import com.inditex.pruebatecnica.model.dto.PriceInputDto;
import com.inditex.pruebatecnica.model.dto.PriceOutputDto;

/**
 * The interface Price service.
 */
public interface PriceService {

    /**
     * Find product data prices entity.
     *
     * @param dto the dto
     * @return the prices entity
     */
    PriceOutputDto findProductData(PriceInputDto dto);
}
