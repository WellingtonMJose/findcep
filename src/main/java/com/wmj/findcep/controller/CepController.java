package com.wmj.findcep.controller;

import com.wmj.findcep.model.Endereco;
import com.wmj.findcep.model.response.Result;
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
    public ResponseEntity<Result<Endereco>> findCep(@PathVariable String cep) {
        Result<Endereco> process = processor.process(cep);
        return ResponseEntity.status(process.getHttpStatus()).body(process);
    }
}
