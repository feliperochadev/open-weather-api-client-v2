package com.finleap.casestudy.feliperocha.openweatherapiclient.mapper;

import com.finleap.casestudy.feliperocha.openweatherapiclient.controller.v1.dto.WeatherForecastDTO;
import com.finleap.casestudy.feliperocha.openweatherapiclient.domain.City;
import com.finleap.casestudy.feliperocha.openweatherapiclient.domain.Weather;
import com.finleap.casestudy.feliperocha.openweatherapiclient.repository.OpenWeatherWeatherResponse;
import org.mapstruct.*;
import com.finleap.casestudy.feliperocha.openweatherapiclient.mapper.WeatherMapperUtil.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = WeatherMapperUtil.class)
public interface WeatherMapper {

    @Mappings({
            @Mapping(source = "dt", target = "dateTime", qualifiedBy = DateTime.class),
            @Mapping(source = "main", target = "temperature.average", qualifiedBy = Temperature.class),
            @Mapping(source = "main", target = "temperature.max", qualifiedBy = MaxTemperature.class),
            @Mapping(source = "main", target = "temperature.min", qualifiedBy = MinTemperature.class),
            @Mapping(source = "main", target = "humidityPercentage", qualifiedBy = HumidityPercentage.class),
            @Mapping(source = "main", target = "atmosphericPressurehPa", qualifiedBy = AtmosphericPressurehPa.class),
            @Mapping(source = "wind", target = "windSpeed", qualifiedBy = WindSpeed.class),
            @Mapping(source = "clouds", target = "cloudinessPercentage", qualifiedBy = CloudinessPercentage.class),
            @Mapping(source = "weather", target = "weatherDescriptions", qualifiedBy = HumidityPercentage.class)
    })
    Weather toWeather(OpenWeatherWeatherResponse openWeatherWeatherResponse);

    @Mappings({
            @Mapping(source = "dt", target = "dateTime", qualifiedBy = DateTime.class),
            @Mapping(source = "main", target = "temperature.average", qualifiedBy = Temperature.class),
            @Mapping(source = "main", target = "temperature.max", qualifiedBy = MaxTemperature.class),
            @Mapping(source = "main", target = "temperature.min", qualifiedBy = MinTemperature.class),
            @Mapping(source = "main", target = "humidityPercentage", qualifiedBy = HumidityPercentage.class),
            @Mapping(source = "main", target = "atmosphericPressurehPa", qualifiedBy = AtmosphericPressurehPa.class),
    })
    WeatherForecastDTO toWeatherDTO(OpenWeatherWeatherResponse openWeatherWeatherResponse);

    List<WeatherForecastDTO> toForecast(List<OpenWeatherWeatherResponse> openWeatherWeatherResponse);

    @Mappings({
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "dt", target = "weather.dateTime", qualifiedBy = DateTime.class),
            @Mapping(source = "main", target = "weather.temperature.average", qualifiedBy = Temperature.class),
            @Mapping(source = "main", target = "weather.temperature.max", qualifiedBy = MaxTemperature.class),
            @Mapping(source = "main", target = "weather.temperature.min", qualifiedBy = MinTemperature.class),
            @Mapping(source = "main", target = "weather.humidityPercentage", qualifiedBy = HumidityPercentage.class),
            @Mapping(source = "main", target = "weather.atmosphericPressurehPa", qualifiedBy = AtmosphericPressurehPa.class),
            @Mapping(source = "wind", target = "weather.windSpeed", qualifiedBy = WindSpeed.class),
            @Mapping(source = "clouds", target = "weather.cloudinessPercentage", qualifiedBy = CloudinessPercentage.class),
            @Mapping(source = "weather", target = "weather.weatherDescriptions", qualifiedBy = HumidityPercentage.class)
    })
    City toCity(OpenWeatherWeatherResponse openWeatherWeatherResponse);

    List<City> toCities(List<OpenWeatherWeatherResponse> openWeatherWeatherResponse);

}
