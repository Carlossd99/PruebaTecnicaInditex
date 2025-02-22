package com.inditex.pruebatecnica.controllerTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.inditex.pruebatecnica.PruebatecnicaApplication;
import com.inditex.pruebatecnica.model.dto.PriceInputDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * The type Price controller i test.
 */
@Slf4j
@SpringBootTest(classes = PruebatecnicaApplication.class) // Especifica la clase principal
@AutoConfigureMockMvc
@ContextConfiguration(classes = {PruebatecnicaApplication.class})
class PriceControllerITest {

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        objectMapper.registerModule(new JavaTimeModule());
    }

    /**
     * Test 1.
     * Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)
     *
     * @throws Exception the exception
     */
    @Test
    void test1() throws Exception {
        PriceInputDto inputDto = new PriceInputDto(35455, 1, LocalDateTime.of(2020, 6, 14, 10, 0));

        mockMvc.perform(post("/prices/producData")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(inputDto)))
                .andExpect(status().isOk());
    }

    /**
     * Test 2.
     * Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)
     *
     * @throws Exception the exception
     */
    @Test
    void test2() throws Exception {
        PriceInputDto inputDto = new PriceInputDto(35455, 1, LocalDateTime.of(2020, 6, 14, 16, 0));

        mockMvc.perform(post("/prices/producData")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(inputDto)))
                .andExpect(status().isOk());
    }

    /**
     * Test 3.
     * Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)
     *
     * @throws Exception the exception
     */
    @Test
    void test3() throws Exception {
        PriceInputDto inputDto = new PriceInputDto(35455, 1, LocalDateTime.of(2020, 6, 14, 21, 0));

        mockMvc.perform(post("/prices/producData")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(inputDto)))
                .andExpect(status().isOk());
    }

    /**
     * Test 4.
     * Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)
     *
     * @throws Exception the exception
     */
    @Test
    void test4() throws Exception {
        PriceInputDto inputDto = new PriceInputDto(35455, 1, LocalDateTime.of(2020, 6, 15, 10, 0));

        mockMvc.perform(post("/prices/producData")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(inputDto)))
                .andExpect(status().isOk());
    }

    /**
     * Test 5.
     * Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)
     *
     * @throws Exception the exception
     */
    @Test
    void test5() throws Exception {
        PriceInputDto inputDto = new PriceInputDto(35455, 1, LocalDateTime.of(2020, 6, 16, 21, 0));

        mockMvc.perform(post("/prices/producData")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(inputDto)))
                .andExpect(status().isOk());
    }
}
