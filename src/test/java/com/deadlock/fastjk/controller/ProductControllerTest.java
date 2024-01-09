package com.deadlock.fastjk.controller;

import com.deadlock.fastjk.core.service.ProductService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {

    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(new ProductController(productService)).build();
    }

    @Test
    void givenInvalidBodyRequest_thenReturns400() throws Exception {
        String bodyRequest = """
                {
                    "name": "product A",
                    "price": -10,
                    "quantity": -1
                }
                """;

        mockMvc.perform(MockMvcRequestBuilders.post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(bodyRequest))
                .andExpect(status().isBadRequest());

    }
}
