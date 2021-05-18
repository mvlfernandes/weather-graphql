package com.mvlfernandes.weather.adapters.entrypoints;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDateTime;

import javax.inject.Inject;

import com.mvlfernandes.weather.adapters.entrypoints.schemas.WeatherSchema;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class WeatherControllerIntegrationTest {

    @Inject
    WeatherController controller;

    @Test
    void shouldInsertWeather() {
        WeatherSchema weatherSchema = new WeatherSchema();
        weatherSchema.setDateTime(LocalDateTime.parse("2021-05-17T21:23:06.575699"));
        weatherSchema.setTemperature(19.7);
        weatherSchema.setWind(9);
        weatherSchema.setHumidity(86);
        weatherSchema.setPressure(705);
        weatherSchema.setDescription("Parcialmente nublado.");
        
        assertDoesNotThrow(() -> {
            controller.addWeather(weatherSchema);
        });
    }

    @Test
    void shouldInsertWeatherFromNow() {
        WeatherSchema weatherSchema = new WeatherSchema();
        weatherSchema.setDateTime(LocalDateTime.now());
        weatherSchema.setTemperature(27.3);
        weatherSchema.setWind(12);
        weatherSchema.setHumidity(45);
        weatherSchema.setPressure(705);
        weatherSchema.setDescription("Ensolarado.");
        
        assertDoesNotThrow(() -> {
            controller.addWeather(weatherSchema);
        });
    }

    @Test
    void shouldGetWeather() throws Exception {
        assertSame(WeatherSchema.class,
                controller.getWeather(LocalDateTime.parse("2021-05-17T21:23:06.575699")).getClass());
    }

    @Test
    void shouldListAll() {
        assertDoesNotThrow(() -> {
            controller.listAllWeather();
        });
    }

}
