package com.inditex.pruebatecnica.model.mapper;

import com.inditex.pruebatecnica.model.dto.PriceOutputDto;
import com.inditex.pruebatecnica.model.h2.PriceEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-22T11:59:02+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class PriceMapperImpl implements PriceMapper {

    @Override
    public PriceOutputDto entityToOutputDto(PriceEntity price) {
        if ( price == null ) {
            return null;
        }

        PriceOutputDto.PriceOutputDtoBuilder priceOutputDto = PriceOutputDto.builder();

        priceOutputDto.brandId( price.getBrandId() );
        priceOutputDto.startDate( price.getStartDate() );
        priceOutputDto.endDate( price.getEndDate() );
        priceOutputDto.priceList( price.getPriceList() );
        priceOutputDto.productId( price.getProductId() );
        priceOutputDto.priority( price.getPriority() );
        priceOutputDto.price( price.getPrice() );
        priceOutputDto.curr( price.getCurr() );

        return priceOutputDto.build();
    }
}
