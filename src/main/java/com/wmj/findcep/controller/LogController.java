package com.wmj.findcep.controller;

import com.wmj.findcep.service.LogService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/log")
@AllArgsConstructor
public class LogController {

    private final LogService logService;

    @GetMapping("/list")
    public ResponseEntity<?> getLog() {
        return ResponseEntity.ok(logService.findAll());
    }

    @GetMapping("/list/{cep}")
    public ResponseEntity<?> getLog(String cep) {
        return ResponseEntity.ok(logService.findByCep(cep));
    }
}
