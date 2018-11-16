package com.finleap.casestudy.feliperocha.openweatherapiclient.service;

import com.finleap.casestudy.feliperocha.openweatherapiclient.configuration.CityProperties;
import com.finleap.casestudy.feliperocha.openweatherapiclient.configuration.OpenWeatherApiProperties;
import com.finleap.casestudy.feliperocha.openweatherapiclient.domain.Forecast;
import com.finleap.casestudy.feliperocha.openweatherapiclient.exception.CityNotInTheList;
import com.finleap.casestudy.feliperocha.openweatherapiclient.mapper.ForecastMapper;
import com.finleap.casestudy.feliperocha.openweatherapiclient.repository.ForecastRepository;
import com.finleap.casestudy.feliperocha.openweatherapiclient.repository.OpenWeatherForecastResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ForecastService {

    private final ForecastRepository forecastRepository;
    private final OpenWeatherApiProperties openWeatherApiProperties;
    private final ForecastMapper forecastMapper;
    private final CityProperties cityProperties;


    @Autowired
    ForecastService(ForecastRepository forecastRepository,
                    OpenWeatherApiProperties openWeatherApiProperties,
                    ForecastMapper forecastMapper,
                    CityProperties cityProperties) {
        this.forecastRepository = forecastRepository;
        this.openWeatherApiProperties = openWeatherApiProperties;
        this.forecastMapper = forecastMapper;
        this.cityProperties = cityProperties;
    }

    public Forecast getForecast(String city) {
        if (cityProperties.getCities().stream().noneMatch(c -> city.toLowerCase().equals(c))) {
            throw new CityNotInTheList(city);
        }

        OpenWeatherForecastResponse openWeatherForecastResponse =
                forecastRepository.getForecast(city, openWeatherApiProperties.getApiId(), openWeatherApiProperties.getDefaultUnit());

        return forecastMapper.toForecast(openWeatherForecastResponse);
    }
}
