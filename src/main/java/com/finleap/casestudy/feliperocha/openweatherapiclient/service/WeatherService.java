package com.finleap.casestudy.feliperocha.openweatherapiclient.service;

import com.finleap.casestudy.feliperocha.openweatherapiclient.configuration.CityProperties;
import com.finleap.casestudy.feliperocha.openweatherapiclient.configuration.OpenWeatherApiProperties;
import com.finleap.casestudy.feliperocha.openweatherapiclient.controller.v1.dto.WeatherForecastDTO;
import com.finleap.casestudy.feliperocha.openweatherapiclient.domain.Weather;
import com.finleap.casestudy.feliperocha.openweatherapiclient.exception.CityNotInTheList;
import com.finleap.casestudy.feliperocha.openweatherapiclient.mapper.WeatherMapper;
import com.finleap.casestudy.feliperocha.openweatherapiclient.repository.OpenWeatherWeatherResponse;
import com.finleap.casestudy.feliperocha.openweatherapiclient.repository.WeatherRepository;
import com.finleap.casestudy.feliperocha.openweatherapiclient.repository.OpenWeatherForecastResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherService {

    private final WeatherRepository weatherRepository;
    private final OpenWeatherApiProperties openWeatherApiProperties;
    private final WeatherMapper weatherMapper;
    private final CityProperties cityProperties;


    @Autowired
    WeatherService(WeatherRepository weatherRepository,
                   OpenWeatherApiProperties openWeatherApiProperties,
                   WeatherMapper weatherMapper,
                   CityProperties cityProperties) {
        this.weatherRepository = weatherRepository;
        this.openWeatherApiProperties = openWeatherApiProperties;
        this.weatherMapper = weatherMapper;
        this.cityProperties = cityProperties;
    }

    public Weather getWeather(String city) {
        if (isCityNotInList(city)) {
            throw new CityNotInTheList(city);
        }

        OpenWeatherWeatherResponse openWeatherWeatherResponse =
                weatherRepository.getWeather(city, openWeatherApiProperties.getApiId(), openWeatherApiProperties.getDefaultUnit());

        return weatherMapper.toWeather(openWeatherWeatherResponse);
    }

    public List<WeatherForecastDTO> getForecast(String city) {
        OpenWeatherForecastResponse openWeatherForecastResponse =
                weatherRepository.getForecast(city, openWeatherApiProperties.getApiId(), openWeatherApiProperties.getDefaultUnit());

        return weatherMapper.toForecast(openWeatherForecastResponse.getList());
    }

    private boolean isCityNotInList(String city) {
        return cityProperties.getCities().stream().noneMatch(c -> city.toLowerCase().equals(c));
    }
}
