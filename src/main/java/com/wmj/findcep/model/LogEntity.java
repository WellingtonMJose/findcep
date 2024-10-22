package com.wmj.findcep.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnTransformer;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "log_entity")
public class LogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cep;

    @Column(columnDefinition = "jsonb")
//    @Convert(converter = JsonColumnConverter.class)
    @ColumnTransformer(write = "?::jsonb")
    private String response;

    @Column(name = "timestamp", nullable = false)
    private LocalDateTime receiving;
}
