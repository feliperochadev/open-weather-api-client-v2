package com.finleap.casestudy.feliperocha.openweatherapiclient.mapper;

import com.finleap.casestudy.feliperocha.openweatherapiclient.domain.Forecast;
import com.finleap.casestudy.feliperocha.openweatherapiclient.repository.OpenWeatherForecastResponse;
import org.mapstruct.*;
import com.finleap.casestudy.feliperocha.openweatherapiclient.mapper.ForecastMapperUtil.*;

@Mapper(componentModel = "spring", uses = ForecastMapperUtil.class)
public interface ForecastMapper {

    @Mappings({
            @Mapping(source = "dt", target = "dateTime", qualifiedBy = DateTime.class),
            @Mapping(source = "main", target = "temperature.current", qualifiedBy = Temperature.class),
            @Mapping(source = "main", target = "temperature.max", qualifiedBy = MaxTemperature.class),
            @Mapping(source = "main", target = "temperature.min", qualifiedBy = MinTemperature.class),
            @Mapping(source = "main", target = "humidityPercentage", qualifiedBy = HumidityPercentage.class),
            @Mapping(source = "main", target = "atmosphericPressurehPa", qualifiedBy = AtmosphericPressurehPa.class),
            @Mapping(source = "wind", target = "windSpeed", qualifiedBy = WindSpeed.class),
            @Mapping(source = "clouds", target = "cloudinessPercentage", qualifiedBy = CloudinessPercentage.class),
            @Mapping(source = "weather", target = "weatherDescriptions", qualifiedBy = HumidityPercentage.class)
    })
    Forecast toForecast(OpenWeatherForecastResponse openWeatherForecastResponse);
}
