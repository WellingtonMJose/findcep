package com.wmj.findcep.service;

import com.wmj.findcep.model.Endereco;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

class CepServiceTest {

    @InjectMocks
    private CepService cepService;

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getCep() {
        String cep = "07260-470";
        String url = "https://viacep.com.br/ws/" + cep + "/json";
        Endereco enderecoEsperado = new Endereco();
        enderecoEsperado.setCep(cep);
        enderecoEsperado.setLogradouro("Rua Victorino Ferreira");
        enderecoEsperado.setBairro("Jardim Oliveira");
        enderecoEsperado.setLocalidade("Guarulhos");
        enderecoEsperado.setUf("SP");
        enderecoEsperado.setEstado("São Paulo");
        Mockito.when(restTemplate.getForObject(url, Endereco.class)).thenReturn(enderecoEsperado);

        Endereco resultado = cepService.getCep(cep);

        assertEquals(enderecoEsperado.getCep(), resultado.getCep());
        assertEquals(enderecoEsperado.getLogradouro(), resultado.getLogradouro());
        assertEquals(enderecoEsperado.getBairro(), resultado.getBairro());
        assertEquals(enderecoEsperado.getLocalidade(), resultado.getLocalidade());
        assertEquals(enderecoEsperado.getUf(), resultado.getUf());

        Mockito.verify(restTemplate,  Mockito.times(1)).getForObject(url, Endereco.class);
    }
}