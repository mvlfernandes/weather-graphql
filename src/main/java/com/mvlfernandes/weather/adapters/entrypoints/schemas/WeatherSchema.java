package com.mvlfernandes.weather.adapters.entrypoints.schemas;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.mvlfernandes.weather.business.entities.Weather;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeatherSchema {
    
    private LocalDateTime dateTime = LocalDateTime.now();
    private Double temperature;
    private Integer wind;
    private Integer humidity;
    private Integer pressure;
    private String description;
    
    public Weather toWeather() {
        return Weather
                .builder()
                .dateTime(this.dateTime)
                .temperature(this.temperature)
                .wind(this.wind)
                .humidity(this.humidity)
                .pressure(this.pressure)
                .description(this.description)
                .build();
    }

    public static WeatherSchema fromWeather(final Weather weather) {
        return WeatherSchema
                .builder()
                .dateTime(weather.getDateTime())
                .temperature(weather.getTemperature())
                .wind(weather.getWind())
                .humidity(weather.getHumidity())
                .pressure(weather.getPressure())
                .description(weather.getDescription())
                .build();
    }

}
