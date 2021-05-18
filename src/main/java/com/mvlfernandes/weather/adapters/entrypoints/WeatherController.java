package com.mvlfernandes.weather.adapters.entrypoints;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.inject.Inject;

import com.mvlfernandes.weather.adapters.entrypoints.schemas.WeatherSchema;
import com.mvlfernandes.weather.business.entities.Weather;
import com.mvlfernandes.weather.business.ports.inside.WeatherServicePort;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;

import io.vertx.core.cli.annotations.Description;

@GraphQLApi
public class WeatherController {

    @Inject
    WeatherServicePort weatherServicePort;

    @Query
    @Description("Get a weather by datetime")
    public WeatherSchema getWeather(final LocalDateTime dateTime) throws Exception {
        final Optional<Weather> weather = Optional.ofNullable(this.weatherServicePort.getWeather(dateTime));

        if (weather.isPresent()) {
            return WeatherSchema.fromWeather(weather.get());
        } else {
            throw new Exception("No weather data found at " + dateTime);
        }
    }

    @Query
    @Description("Get all weather")
    public List<WeatherSchema> listAllWeather() {
        final List<WeatherSchema> weatherList = this.weatherServicePort
            .listAllWeather()
            .stream()
            .map(WeatherSchema::fromWeather)
            .collect(Collectors.toList());

        return weatherList;
    }

    @Mutation
    public LocalDateTime addWeather(final WeatherSchema weatherSchema) {
        Weather weather = this.weatherServicePort.addWeather(weatherSchema.toWeather());
        
        return weather.getDateTime();
    }

}
