package com.inditex.pruebatecnica.serviceTest.impl;

import com.inditex.pruebatecnica.exceptions.PriceNotFoundException;
import com.inditex.pruebatecnica.model.dto.PriceInputDto;
import com.inditex.pruebatecnica.model.dto.PriceOutputDto;
import com.inditex.pruebatecnica.model.h2.PriceEntity;
import com.inditex.pruebatecnica.model.mapper.PriceMapper;
import com.inditex.pruebatecnica.repository.PricesRepository;
import com.inditex.pruebatecnica.service.impl.PriceServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class PriceServiceImplTest {

    @Mock
    private PricesRepository pricesRepository;

    @Mock
    private PriceMapper priceMapper;

    @InjectMocks
    private PriceServiceImpl priceService;

    private PriceInputDto priceInputDto;
    private PriceEntity priceEntity;
    private PriceOutputDto priceOutputDto;


    @BeforeEach
    void setUp() {
        priceInputDto = PriceInputDto.builder()
                .brandId(1)
                .productId(35455)
                .date(LocalDateTime.of(2020, 6, 14, 10, 0))
                .build();

        priceEntity = PriceEntity.builder()
                .brandId(1)
                .startDate(LocalDateTime.of(2020, 6, 14, 0, 0))
                .endDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59))
                .priceList(1)
                .productId(35455)
                .priority(1)
                .price(BigDecimal.valueOf(35.50))
                .curr("EUR")
                .build();


        priceOutputDto = PriceOutputDto.builder()
                .brandId(1)
                .startDate(LocalDateTime.of(2020, 6, 14, 0, 0))
                .endDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59))
                .priceList(1)
                .productId(35455)
                .priority(1)
                .price(BigDecimal.valueOf(35.50))
                .curr("EUR")
                .build();
    }

    @Test
    void findProductDataOK() {
        when(pricesRepository.findPrice(anyInt(), anyInt(), any())).thenReturn(Optional.of(priceEntity));
        when(priceMapper.entityToOutputDto(any())).thenReturn(priceOutputDto);

        PriceOutputDto result = priceService.findProductData(priceInputDto);

        Assertions.assertEquals(result.getPrice(), BigDecimal.valueOf(35.50));
    }

    @Test
    void findProductDatKO() {
        when(pricesRepository.findPrice(anyInt(), anyInt(), any())).thenReturn(Optional.empty());

        assertThrows(PriceNotFoundException.class, () -> priceService.findProductData(priceInputDto));
    }

}
