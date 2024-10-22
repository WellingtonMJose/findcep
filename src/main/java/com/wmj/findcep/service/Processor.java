package com.wmj.findcep.service;

import com.wmj.findcep.model.Endereco;
import com.wmj.findcep.model.Result;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class Processor {
    private final CepService cepService;
    private final LogService logService;

    public Result process(String cep) {
        Result result = new Result();
        Endereco endereco = cepService.getCep(cep);
        if (endereco != null && endereco.getEstado() != null) {
            logService.save(cep, endereco.toJson());
            result.addMessage("Cep encontrado com sucesso!");
            result.addData(endereco.toJson());
            return result;
        };
        result.addMessage("Cep não encontrado");
        result.addData(null);
        return result;
    }

}
