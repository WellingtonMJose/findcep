package com.wmj.findcep.repository;

import com.wmj.findcep.model.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogRepository extends JpaRepository<LogEntity, Long> {
    List<LogEntity> findByCep(String cep);
}
