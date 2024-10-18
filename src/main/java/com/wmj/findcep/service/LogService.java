package com.wmj.findcep.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wmj.findcep.model.LogEntity;
import com.wmj.findcep.repository.LogRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class LogService {

    private final LogRepository logRepository;
    private final ObjectMapper objectMapper;

    public void save(String cep, String response) throws JsonProcessingException {
        JsonNode jsonResponse = objectMapper.readTree(response);
        LogEntity logEntity = new LogEntity();
        logEntity.setCep(cep);
        logEntity.setResponse(jsonResponse.toString());
        logEntity.setTimestamp(LocalDateTime.now());
        logRepository.save(logEntity);
    }
}
