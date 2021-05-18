package com.mvlfernandes.weather.business.ports.outside;

import java.time.LocalDateTime;
import java.util.List;

import com.mvlfernandes.weather.business.entities.Weather;

public interface WeatherGatewayPort {

    Weather select(LocalDateTime dateTime);
    List<Weather> selectAll();
    Weather insert(Weather weather);
    
}
