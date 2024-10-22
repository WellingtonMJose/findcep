package com.wmj.findcep.service;

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
        logService.save("0395423","{\n" +
                "   \"cep\": \"01201-050\",\n" +
                "   \"logradouro\": \"PRACA OLAVO BILAC\",\n" +
                "   \"bairro\": \"CAMPOS ELISEOS\",\n" +
                "   \"localidade\": \"São Paulo\",\n" +
                "   \"uf\": \"SP\",\n" +
                "   \"ddd\": \"11\"\n" +
                "   } ");

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