package com.wmj.findcep.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CepService {
    private final RestTemplate restTemplate;

    public String getCep(String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json";
        return restTemplate.getForObject(url, String.class);
    }
}
