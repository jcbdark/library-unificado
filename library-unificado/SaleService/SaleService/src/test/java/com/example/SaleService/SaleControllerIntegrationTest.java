package com.example.SaleService;

import com.example.SaleService.dto.SaleDTO;
import com.example.SaleService.repository.SaleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class SaleControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SaleRepository saleRepository;

    @Test
    void testCreateSale() throws Exception {
        SaleDTO saleDTO = new SaleDTO();
        saleDTO.setCustomerId(1L);
        saleDTO.setTotal(150.0);

        mockMvc.perform(post("/api/sales")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(saleDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.customerId").value(1L))
                .andExpect(jsonPath("$.totalAmount").value(150.0));
    }

    @Test
    void testGetAllSales() throws Exception {
        mockMvc.perform(get("/api/sales"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    void testGetSaleById() throws Exception {
        // Crear venta primero
        SaleDTO saleDTO = new SaleDTO();
        saleDTO.setCustomerId(2L);
        saleDTO.setTotal(200.0);

        String content = mockMvc.perform(post("/api/sales")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(saleDTO)))
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString();

        SaleDTO createdSale = objectMapper.readValue(content, SaleDTO.class);

        mockMvc.perform(get("/api/sales/" + createdSale.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customerId").value(2L))
                .andExpect(jsonPath("$.totalAmount").value(200.0));
    }

    @Test
    void testDeleteSale() throws Exception {
        // Crear venta
        SaleDTO saleDTO = new SaleDTO();
        saleDTO.setCustomerId(3L);
        saleDTO.setTotal(300.0);

        String content = mockMvc.perform(post("/api/sales")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(saleDTO)))
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString();

        SaleDTO createdSale = objectMapper.readValue(content, SaleDTO.class);

        // Borrar venta
        mockMvc.perform(delete("/api/sales/" + createdSale.getId()))
                .andExpect(status().isNoContent());
    }
}
