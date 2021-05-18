package com.mvlfernandes.weather.business.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.mvlfernandes.weather.business.entities.Weather;
import com.mvlfernandes.weather.business.ports.inside.WeatherServicePort;
import com.mvlfernandes.weather.business.ports.outside.WeatherGatewayPort;

@ApplicationScoped
public class WeatherService implements WeatherServicePort {

    @Inject
    WeatherGatewayPort weatherGatewayPort;

    @Override
    public Weather getWeather(final LocalDateTime dateTime) {
        return this.weatherGatewayPort.select(dateTime);
    }

    @Override
    public List<Weather> listAllWeather() {
        return this.weatherGatewayPort.selectAll();
    }

    @Override
    public Weather addWeather(final Weather weather) {
        return this.weatherGatewayPort.insert(weather);
    }
    
}
