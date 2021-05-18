package com.mvlfernandes.weather.adapters.entrypoints.schemas;

import static org.junit.jupiter.api.Assertions.assertSame;

import com.mvlfernandes.weather.business.entities.Weather;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class WeatherSchemaTest {

    @Test
    void isWeatherType() {
        WeatherSchema weatherSchema = new WeatherSchema();
        assertSame(Weather.class, weatherSchema.toWeather().getClass());
    }

    @Test
    void isWeatherSchemaType() {
        Weather weather = Weather.builder().build();
        assertSame(WeatherSchema.class, WeatherSchema.fromWeather(weather).getClass());
    }
    
}
