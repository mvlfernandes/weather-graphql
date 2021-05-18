package com.mvlfernandes.weather.business.ports.inside;

import java.time.LocalDateTime;
import java.util.List;

import com.mvlfernandes.weather.business.entities.Weather;

public interface WeatherServicePort {

    Weather getWeather(LocalDateTime dateTime);
    List<Weather> listAllWeather();
    Weather addWeather(Weather weather);
    
}
