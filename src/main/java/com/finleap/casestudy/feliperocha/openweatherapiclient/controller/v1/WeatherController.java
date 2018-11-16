package com.finleap.casestudy.feliperocha.openweatherapiclient.controller.v1;

import com.finleap.casestudy.feliperocha.openweatherapiclient.controller.v1.dto.CitiesWeatherInfoDTO;
import com.finleap.casestudy.feliperocha.openweatherapiclient.controller.v1.dto.WeatherForecastDTO;
import com.finleap.casestudy.feliperocha.openweatherapiclient.domain.Weather;
import com.finleap.casestudy.feliperocha.openweatherapiclient.service.WeatherService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.finleap.casestudy.feliperocha.openweatherapiclient.controller.BaseControllerHeader.API_V1;
import static com.finleap.casestudy.feliperocha.openweatherapiclient.controller.BaseControllerHeader.APPLICATION_JSON;

@RestController
@RequestMapping(path = "/weather", produces = { APPLICATION_JSON }, headers = { API_V1 })
@Api(value = "Weather", description = "Operations on Weather level")
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    @RequestMapping(path = "/{city}")
    public ResponseEntity<Weather> getWeather(@PathVariable String city) {
        return ResponseEntity.ok(weatherService.getWeather(city));
    }

    @GetMapping
    @RequestMapping(path = "/{city}/forecast")
    public ResponseEntity<List<WeatherForecastDTO>> getForecast(@PathVariable String city) {
        return ResponseEntity.ok(weatherService.getForecast(city));
    }

    @GetMapping
    @RequestMapping(path = "/cities")
    public ResponseEntity<CitiesWeatherInfoDTO> getCitiesWeatherInfo() {
        return ResponseEntity.ok(weatherService.getCitiesWeatherInfo());
    }
}
