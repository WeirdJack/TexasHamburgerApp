package com.bhargav.texashamco.dto.interceptor;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class InterceptorDTO {

    private int id;
    private long startTime;
    private long endTime;
    private long executionTime;
    private String url;
    private LocalDate urlDate;
}
