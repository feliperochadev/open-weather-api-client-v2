package com.finleap.casestudy.feliperocha.openweatherapiclient.mapper;

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

    List<Weather> toForecast(List<OpenWeatherWeatherResponse> openWeatherWeatherResponse);
}
