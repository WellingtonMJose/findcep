package com.wmj.findcep.controller;

import com.wmj.findcep.model.response.Result;
import com.wmj.findcep.service.Processor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@WebMvcTest(controllers = CepController.class)
class CepControllerTest {

    @MockBean
    private Processor processor;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findCep() throws Exception {
        Result endereco = Mockito.mock(Result.class);
        Mockito.when(processor.process(Mockito.anyString())).thenReturn(endereco);
        this.mockMvc.perform(
                get("/api/cep/98745632")
                        .content("12345678")
                        .contentType(MediaType.ALL_VALUE));

    }
}