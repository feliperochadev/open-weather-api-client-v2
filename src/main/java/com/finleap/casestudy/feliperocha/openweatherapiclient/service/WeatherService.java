package com.finleap.casestudy.feliperocha.openweatherapiclient.service;

import com.finleap.casestudy.feliperocha.openweatherapiclient.configuration.CityProperties;
import com.finleap.casestudy.feliperocha.openweatherapiclient.configuration.OpenWeatherApiProperties;
import com.finleap.casestudy.feliperocha.openweatherapiclient.controller.v1.dto.*;
import com.finleap.casestudy.feliperocha.openweatherapiclient.domain.City;
import com.finleap.casestudy.feliperocha.openweatherapiclient.domain.Temperature;
import com.finleap.casestudy.feliperocha.openweatherapiclient.domain.Weather;
import com.finleap.casestudy.feliperocha.openweatherapiclient.exception.CityNotInTheList;
import com.finleap.casestudy.feliperocha.openweatherapiclient.mapper.WeatherMapper;
import com.finleap.casestudy.feliperocha.openweatherapiclient.repository.OpenWeatherCitiesWeatherInfoResponse;
import com.finleap.casestudy.feliperocha.openweatherapiclient.repository.OpenWeatherWeatherResponse;
import com.finleap.casestudy.feliperocha.openweatherapiclient.repository.WeatherRepository;
import com.finleap.casestudy.feliperocha.openweatherapiclient.repository.OpenWeatherForecastResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.template.TemplateLocation;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public CitiesWeatherInfoDTO getCitiesWeatherInfo() {
        OpenWeatherCitiesWeatherInfoResponse openWeatherCitiesWeatherInfoResponse =
                weatherRepository.getCitiesWeatherInfo(String.join(",", cityProperties.getCities().values()),
                        openWeatherApiProperties.getApiId(),
                        openWeatherApiProperties.getDefaultUnit());
        List<City> cities = weatherMapper.toCities(openWeatherCitiesWeatherInfoResponse.getList());

        List<CityTemperatureDTO> citiesTemperatureDTO = cities.stream()
                .map(c -> new CityTemperatureDTO(c.getName(), c.getWeather().getTemperature().getAverage()))
                .collect(Collectors.toList());

        CityWithHighestHumidityDTO cityWithHighestHumidityDTO = cities.stream()
                .map(c -> new CityWithHighestHumidityDTO(c.getName(), c.getWeather().getHumidityPercentage()))
                .max(Comparator.comparing(c -> Integer.parseInt(c.getHumidityPercentage()))).orElse(null);

        CityWithHighestTemperatureDTO cityWithHighestTemperatureDTO = cities.stream()
                .map(c -> new CityWithHighestTemperatureDTO(c.getName(), c.getWeather().getTemperature().getMax()))
                .max(Comparator.comparing(c -> Integer.parseInt(c.getMaxTemperature()))).orElse(null);

        return new CitiesWeatherInfoDTO(citiesTemperatureDTO, cityWithHighestHumidityDTO, cityWithHighestTemperatureDTO);
    }

    private boolean isCityNotInList(String city) {
        return !cityProperties.getCities().containsKey(city.toLowerCase());
    }
}
