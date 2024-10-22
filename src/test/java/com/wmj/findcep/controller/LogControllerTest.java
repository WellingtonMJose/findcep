package com.wmj.findcep.controller;

import com.wmj.findcep.model.Endereco;
import com.wmj.findcep.model.LogEntity;
import com.wmj.findcep.service.LogService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(controllers = LogController.class)
class LogControllerTest {

    @MockBean
    private LogService logService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getLog() throws Exception {
        List<LogEntity> list = Arrays.asList(Mockito.mock(LogEntity.class));
        Mockito.when(logService.findAll()).thenReturn(list);
        this.mockMvc.perform(
                get("/api/log/list")
                        .contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void testGetLog() throws Exception {
        List<LogEntity> list = Arrays.asList(Mockito.mock(LogEntity.class));
        Mockito.when(logService.findByCep(Mockito.anyString())).thenReturn(list);
        this.mockMvc.perform(
                get("/api/log/list/987654321")
                        .content("987654321")
                        .contentType(MediaType.APPLICATION_JSON));
    }
}