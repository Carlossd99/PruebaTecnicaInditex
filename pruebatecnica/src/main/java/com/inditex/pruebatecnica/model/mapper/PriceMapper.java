package com.inditex.pruebatecnica.model.mapper;

import com.inditex.pruebatecnica.model.dto.PriceOutputDto;
import com.inditex.pruebatecnica.model.h2.PriceEntity;
import org.mapstruct.Mapper;

/**
 * The interface Price mapper.
 */
@Mapper(componentModel = "spring")
public interface PriceMapper {

    /**
     * Entity to output dto price output dto.
     *
     * @param price the price
     * @return the price output dto
     */
    PriceOutputDto entityToOutputDto(PriceEntity price);
}
