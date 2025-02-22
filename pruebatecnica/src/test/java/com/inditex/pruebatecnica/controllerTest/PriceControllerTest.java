package com.inditex.pruebatecnica.controllerTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.inditex.pruebatecnica.controller.PriceController;
import com.inditex.pruebatecnica.exceptions.PriceNotFoundException;
import com.inditex.pruebatecnica.model.dto.PriceInputDto;
import com.inditex.pruebatecnica.model.dto.PriceOutputDto;
import com.inditex.pruebatecnica.service.impl.PriceServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * The type Price controller test.
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(PriceController.class)
public class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PriceServiceImpl priceServiceImpl;

    private PriceInputDto priceInputDto;
    private PriceOutputDto priceOutputDto;
    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {

        objectMapper.registerModule(new JavaTimeModule());

        priceInputDto = PriceInputDto.builder()
                .brandId(1)
                .productId(35455)
                .date(LocalDateTime.of(2020, 6, 14, 10, 0))
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

    /**
     * Should return price when valid request.
     *
     * @throws Exception the exception
     */
    @Test
    void shouldReturnPriceWhenValidRequest() throws Exception {
        when(priceServiceImpl.findProductData(any())).thenReturn(priceOutputDto);

        mockMvc.perform(post("/prices/producData")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(priceInputDto)))
                .andExpect(status().isOk());
    }

    /**
     * Should return 404 when price not found.
     *
     * @throws Exception the exception
     */
    @Test
    void shouldReturn404WhenPriceNotFound() throws Exception {
        when(priceServiceImpl.findProductData(any()))
                .thenThrow(new PriceNotFoundException("No hay datos disponibles para mostrar"));

        mockMvc.perform(post("/prices/producData")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(priceInputDto)))
                .andExpect(status().isNotFound());
    }

    /**
     * Should return 400 when input is invalid.
     *
     * @throws Exception the exception
     */
    @Test
    void shouldReturn400WhenInputIsInvalid() throws Exception {
        PriceInputDto invalidDto = new PriceInputDto(); // Campos vacíos

        mockMvc.perform(post("/prices/producData")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(invalidDto)))
                .andExpect(status().isBadRequest());
    }


    /**
     * Should return 404 when price not found.
     *
     * @throws Exception the exception
     */
    @Test
    void handleGeneralExceptionTest() throws Exception {
        when(priceServiceImpl.findProductData(any()))
                .thenThrow(new InternalError("Error generico"));

        mockMvc.perform(post("/prices/producData")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(priceInputDto)))
                .andExpect(status().isInternalServerError());
    }

}
