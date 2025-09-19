package com.example.CustomerService;


import com.example.CustomerService.dto.CustomerDTO;
import com.example.CustomerService.repository.CustomerRepository;
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
class CustomerControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void testCreateCustomer() throws Exception {
        CustomerDTO dto = new CustomerDTO();
        dto.setName("Juan Perez");
        dto.setEmail("juan.perez@example.com");

        mockMvc.perform(post("/api/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Juan Perez"))
                .andExpect(jsonPath("$.email").value("juan.perez@example.com"));
    }

    @Test
    void testGetAllCustomers() throws Exception {
        mockMvc.perform(get("/api/customers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    void testGetCustomerById() throws Exception {
        // Primero crear un cliente
        CustomerDTO dto = new CustomerDTO();
        dto.setName("Maria Lopez");
        dto.setEmail("maria.lopez@example.com");

        String content = mockMvc.perform(post("/api/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        CustomerDTO createdCustomer = objectMapper.readValue(content, CustomerDTO.class);

        mockMvc.perform(get("/api/customers/" + createdCustomer.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Maria Lopez"))
                .andExpect(jsonPath("$.email").value("maria.lopez@example.com"));
    }

    @Test
    void testUpdateCustomer() throws Exception {
        // Crear cliente
        CustomerDTO dto = new CustomerDTO();
        dto.setName("Carlos Ramos");
        dto.setEmail("carlos.ramos@example.com");

        String content = mockMvc.perform(post("/api/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        CustomerDTO createdCustomer = objectMapper.readValue(content, CustomerDTO.class);

        // Actualizar cliente
        CustomerDTO updateDto = new CustomerDTO();
        updateDto.setName("Carlos R.");
        updateDto.setEmail("carlos.r@example.com");

        mockMvc.perform(put("/api/customers/" + createdCustomer.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updateDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Carlos R."))
                .andExpect(jsonPath("$.email").value("carlos.r@example.com"));
    }

    @Test
    void testDeleteCustomer() throws Exception {
        // Crear cliente
        CustomerDTO dto = new CustomerDTO();
        dto.setName("Ana Torres");
        dto.setEmail("ana.torres@example.com");

        String content = mockMvc.perform(post("/api/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        CustomerDTO createdCustomer = objectMapper.readValue(content, CustomerDTO.class);

        // Borrar cliente
        mockMvc.perform(delete("/api/customers/" + createdCustomer.getId()))
                .andExpect(status().isNoContent());
    }
}

