package com.mvlfernandes.weather.adapters.gateways.db.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mvlfernandes.weather.business.entities.Weather;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="weather")
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class WeatherEntity extends PanacheEntityBase {
    
    @Id
    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Column(name = "temperature")
    private Double temperature;

    @Column(name = "wind")
    private Integer wind;

    @Column(name = "humidity")
    private Integer humidity;

    @Column(name = "pressure")
    private Integer pressure;

    @Column(name = "description")
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

    public static WeatherEntity fromWeather(final Weather weather) {
        return WeatherEntity
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
