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

@Slf4j
@SpringBootTest(classes = PruebatecnicaApplication.class) // Especifica la clase principal
@AutoConfigureMockMvc
@ContextConfiguration(classes = {PruebatecnicaApplication.class})
class PriceControllerITest {

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Test
    void test1() throws Exception {
        PriceInputDto inputDto = new PriceInputDto(35455, 1, LocalDateTime.of(2020, 6, 14, 10, 0));

        mockMvc.perform(post("/prices/producData")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(inputDto)))
                .andExpect(status().isOk());
    }

    @Test
    void test2() throws Exception {
        PriceInputDto inputDto = new PriceInputDto(35455, 1, LocalDateTime.of(2020, 6, 14, 16, 0));

        mockMvc.perform(post("/prices/producData")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(inputDto)))
                .andExpect(status().isOk());
    }

    @Test
    void test3() throws Exception {
        PriceInputDto inputDto = new PriceInputDto(35455, 1, LocalDateTime.of(2020, 6, 14, 21, 0));

        mockMvc.perform(post("/prices/producData")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(inputDto)))
                .andExpect(status().isOk());
    }

    @Test
    void test4() throws Exception {
        PriceInputDto inputDto = new PriceInputDto(35455, 1, LocalDateTime.of(2020, 6, 15, 10, 0));

        mockMvc.perform(post("/prices/producData")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(inputDto)))
                .andExpect(status().isOk());
    }

    @Test
    void test5() throws Exception {
        PriceInputDto inputDto = new PriceInputDto(35455, 1, LocalDateTime.of(2020, 6, 16, 21, 0));

        mockMvc.perform(post("/prices/producData")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(inputDto)))
                .andExpect(status().isOk());
    }
}
