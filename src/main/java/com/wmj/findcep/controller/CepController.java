package com.wmj.findcep.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.JsonObject;
import com.wmj.findcep.model.Endereco;
import com.wmj.findcep.model.Result;
import com.wmj.findcep.service.CepService;
import com.wmj.findcep.service.LogService;
import com.wmj.findcep.service.Processor;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cep")
@AllArgsConstructor
public class CepController {

    private final Processor processor;

    @GetMapping("/{cep}")
    @Operation(summary = "Buscar cep")
    public ResponseEntity<Result> findCep(@PathVariable String cep) {
        return ResponseEntity.ok(processor.process(cep));
    }
}
