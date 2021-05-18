package com.mvlfernandes.weather.adapters.gateways.db;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.mvlfernandes.weather.adapters.gateways.db.entities.WeatherEntity;
import com.mvlfernandes.weather.business.entities.Weather;
import com.mvlfernandes.weather.business.ports.outside.WeatherGatewayPort;

import org.jboss.logging.Logger;

@ApplicationScoped
public class WeatherDbGateway implements WeatherGatewayPort {
    
    @Inject
    Logger logger;

    @Override
    public Weather select(final LocalDateTime dateTime) {
        try {
            final Optional<WeatherEntity> weatherEntity = Optional.ofNullable(WeatherEntity.findById(dateTime));
            
            if (weatherEntity.isPresent()) {
                return weatherEntity.get().toWeather();
            }
        } catch (Exception e) {
            logger.errorf("Failed to select weather data at ", dateTime);
        }
        return null;
    }

    @Override
    public List<Weather> selectAll() {
        try {
            final List<WeatherEntity> weatherList = WeatherEntity.listAll();

            return weatherList
                .stream()
                .map(WeatherEntity::toWeather)
                .collect(Collectors.toList());
        } catch (Exception e) {
            logger.errorf("Failed to select all weather data");
        }
        return null;
    }

    @Override
    @Transactional
    public Weather insert(final Weather weather) {
        try {
            final WeatherEntity weatherEntity = WeatherEntity.fromWeather(weather);
            WeatherEntity.persist(weatherEntity);
            return weatherEntity.toWeather();
        } catch (Exception e) {
            logger.errorf("Failed to insert weather data at ", weather.getDateTime());
        }
        return null;
    }
    
}
