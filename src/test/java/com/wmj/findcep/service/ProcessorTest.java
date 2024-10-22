package com.wmj.findcep.service;

import com.wmj.findcep.model.Endereco;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class ProcessorTest {

    @InjectMocks
    Processor processor;

    @Mock
    CepService cepService;

    @Mock
    LogService logService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void process() {
        Endereco enderecoEsperado = new Endereco();
        enderecoEsperado.setCep("2523634");
        enderecoEsperado.setLogradouro("Rua Victorino Ferreira");
        enderecoEsperado.setBairro("Jardim Oliveira");
        enderecoEsperado.setLocalidade("Guarulhos");
        enderecoEsperado.setUf("SP");
        enderecoEsperado.setEstado("São Paulo");
        Mockito.when(cepService.getCep(Mockito.anyString())).thenReturn(enderecoEsperado);

        processor.process("2354252");

        Mockito.verify(cepService).getCep(Mockito.anyString());
        Mockito.verify(logService).save(Mockito.anyString(), Mockito.anyString());
    }

    @Test
    void processCepNotFound() {
        Endereco enderecoEsperado = new Endereco();
        enderecoEsperado.setCep(null);
        enderecoEsperado.setLogradouro(null);
        enderecoEsperado.setBairro(null);
        enderecoEsperado.setLocalidade(null);
        enderecoEsperado.setUf(null);
        enderecoEsperado.setEstado(null);
        Mockito.when(cepService.getCep(Mockito.anyString())).thenReturn(enderecoEsperado);

        processor.process("2354252");

        Mockito.verify(cepService).getCep(Mockito.anyString());
    }
}