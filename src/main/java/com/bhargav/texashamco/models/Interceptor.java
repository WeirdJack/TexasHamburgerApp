package com.bhargav.texashamco.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Interceptor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private long startTime;
    private long endTime;
    private long executionTime;
    private String url;
    private LocalDate urlDate;
}
