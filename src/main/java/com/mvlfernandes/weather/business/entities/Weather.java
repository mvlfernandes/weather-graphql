package com.mvlfernandes.weather.business.entities;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Weather {

    private LocalDateTime dateTime;
    private Double temperature;
    private Integer wind;
    private Integer humidity;
    private Integer pressure;
    private String description;
    
}
