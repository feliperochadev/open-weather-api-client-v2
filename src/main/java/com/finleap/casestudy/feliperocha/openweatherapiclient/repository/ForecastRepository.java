package com.finleap.casestudy.feliperocha.openweatherapiclient.repository;

import feign.Param;
import feign.RequestLine;

import java.util.HashMap;

public interface ForecastRepository {
    @RequestLine("GET /weather?q={city}&appid={apiId}&units={unity}")
    OpenWeatherForecastResponse getForecast(@Param("city") String city, @Param("apiId") String apiId, @Param("unity") String unity);
}

