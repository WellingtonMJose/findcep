package com.wmj.findcep.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.wmj.findcep.service.CepService;
import com.wmj.findcep.service.LogService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cep")
@AllArgsConstructor
public class CepController {

    private final CepService cepService;
    private final LogService logService;

    @GetMapping("/{cep}")
    @Operation(summary = "Buscar cep")
    public String findCep(@PathVariable String cep) throws JsonProcessingException {
        String response = cepService.getCep(cep);
        logService.save(cep, response);
        return response;
    }
}
