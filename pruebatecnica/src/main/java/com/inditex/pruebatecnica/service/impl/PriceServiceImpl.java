package com.inditex.pruebatecnica.service.impl;

import com.inditex.pruebatecnica.exceptions.PriceNotFoundException;
import com.inditex.pruebatecnica.model.dto.PriceInputDto;
import com.inditex.pruebatecnica.model.dto.PriceOutputDto;
import com.inditex.pruebatecnica.model.h2.PriceEntity;
import com.inditex.pruebatecnica.model.mapper.PriceMapper;
import com.inditex.pruebatecnica.repository.PricesRepository;
import com.inditex.pruebatecnica.service.PriceService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * The type Price service.
 */
@Service
public class PriceServiceImpl implements PriceService {

    private final PricesRepository pricesRepository;

    private final PriceMapper priceMapper;

    /**
     * Instantiates a new Price service.
     *
     * @param pricesRepository the prices repository
     * @param priceMapper      the price mapper
     */
    public PriceServiceImpl(PricesRepository pricesRepository, PriceMapper priceMapper) {
        this.pricesRepository = pricesRepository;
        this.priceMapper = priceMapper;

    }

    @Override
    @Cacheable(value = "PRICES", key = "#dto.brandId + '-' + #dto.productId + '-' + #dto.date")
    public PriceOutputDto findProductData(PriceInputDto dto) {

        //Acceso a la base de datos para recuperar los datos del producto
        Optional<PriceEntity> priceEntity = pricesRepository
                .findPrice(dto.getProductId(), dto.getBrandId(), dto.getDate());

        //Funcion para retornar la salida mappeada a un DTO de salida
        //En caso de no tener datos, retornar error
        return priceEntity.map(priceMapper::entityToOutputDto)
                .orElseThrow(() -> new PriceNotFoundException("No hay datos disponibles para mostrar"));
    }
}
