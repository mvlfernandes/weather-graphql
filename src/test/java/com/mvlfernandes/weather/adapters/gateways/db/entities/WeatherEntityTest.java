package com.mvlfernandes.weather.adapters.gateways.db.entities;

import static org.junit.jupiter.api.Assertions.assertSame;

import com.mvlfernandes.weather.business.entities.Weather;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class WeatherEntityTest {
    
    @Test
    void isWeatherType() {
        WeatherEntity weatherEntity = new WeatherEntity();
        assertSame(Weather.class, weatherEntity.toWeather().getClass());
    }

    @Test
    void isWeatherSchemaType() {
        Weather weather = Weather.builder().build();
        assertSame(WeatherEntity.class, WeatherEntity.fromWeather(weather).getClass());
    }

}
