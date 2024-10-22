package com.wmj.findcep.service;

import com.wmj.findcep.model.Endereco;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CepService {
    private final RestTemplate restTemplate;

    public Endereco getCep(String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json";
        return restTemplate.getForObject(url, Endereco.class);
    }
}
