package com.finleap.casestudy.feliperocha.openweatherapiclient.repository;

import feign.Param;
import feign.RequestLine;

public interface WeatherRepository {
    @RequestLine("GET /weather?q={city}&appid={apiId}&units={unity}")
    OpenWeatherResponse getWeather(@Param("city") String city, @Param("apiId") String apiId, @Param("unity") String unity);

    @RequestLine("GET /forecast?q={city}&appid={apiId}&units={unity}")
    OpenWeatherForecastResponse getForecast(@Param("city") String city, @Param("apiId") String apiId, @Param("unity") String unity);

    @RequestLine("GET /group?id={cityIds}&appid={apiId}&units={unity}")
    OpenWeatherCitiesWeatherInfoResponse getCitiesWeatherInfo(@Param("cityIds") String cityIds, @Param("apiId") String apiId, @Param("unity") String unity);
}

