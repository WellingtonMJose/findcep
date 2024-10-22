package com.wmj.findcep.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.wmj.findcep.model.Endereco;
import com.wmj.findcep.model.response.Result;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class Processor {
    private final CepService cepService;
    private final LogService logService;

    public Result<Endereco> process(String cep) {
        Result<Endereco> result = new Result<Endereco>();
        Endereco endereco = cepService.getCep(cep);
        Gson gson = new Gson();
        String jsonString = gson.toJson(endereco);
        JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);
        if (jsonObject != null && jsonObject.has("logradouro")) {
            logService.save(cep, jsonObject);
            result.addMessage("Cep encontrado com sucesso!");
            result.addData(endereco);
            result.addHttpStatus(HttpStatus.OK);
            return result;
        };
        result.addMessage("Cep não encontrado");
        result.addData(null);
        result.addHttpStatus(HttpStatus.NOT_FOUND);
        return result;
    }

}
