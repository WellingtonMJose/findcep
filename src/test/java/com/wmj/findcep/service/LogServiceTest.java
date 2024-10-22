package com.wmj.findcep.service;

import com.google.gson.JsonObject;
import com.wmj.findcep.model.LogEntity;
import com.wmj.findcep.repository.LogRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LogServiceTest {

    @InjectMocks
    private LogService logService;

    @Mock
    private LogRepository logRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void save() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("cep", "0395423");
        jsonObject.addProperty("logradouro", "PRACA OLAVO BILAC");
        jsonObject.addProperty("bairro", "CAMPOS ELISEOS");
        jsonObject.addProperty("localidade", "São Paulo");
        jsonObject.addProperty("uf", "SP");
        jsonObject.addProperty("ddd", "11");

        logService.save("0395423",jsonObject);

        Mockito.verify(logRepository).save(Mockito.any(LogEntity.class));
    }

    @Test
    void findAll() {
        Mockito.when(logRepository.findAll()).thenReturn(Arrays.asList(Mockito.mock(LogEntity.class), Mockito.mock(LogEntity.class), Mockito.mock(LogEntity.class)));
        List<LogEntity> list = logService.findAll();

        Assertions.assertNotNull(list);
    }

    @Test
    void findByCep() {
        Mockito.when(logRepository.findAll()).thenReturn(Arrays.asList(Mockito.mock(LogEntity.class), Mockito.mock(LogEntity.class), Mockito.mock(LogEntity.class)));
        List<LogEntity> list = logService.findByCep("12414141");

        Assertions.assertNotNull(list);
    }
}