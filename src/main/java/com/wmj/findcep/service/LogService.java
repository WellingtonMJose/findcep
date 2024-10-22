package com.wmj.findcep.service;

import com.google.gson.JsonObject;
import com.wmj.findcep.model.LogEntity;
import com.wmj.findcep.repository.LogRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class LogService {

    private final LogRepository logRepository;

    public void save(String cep, String response) {
        LogEntity logEntity = new LogEntity();
        logEntity.setCep(cep);
        logEntity.setResponse(response);
        logEntity.setReceiving(LocalDateTime.now());
        logRepository.save(logEntity);
    }

    public List<LogEntity> findAll() {
        return logRepository.findAll();
    }

    public List<LogEntity> findByCep(String cep) {
        return logRepository.findByCep(cep);
    }
}
