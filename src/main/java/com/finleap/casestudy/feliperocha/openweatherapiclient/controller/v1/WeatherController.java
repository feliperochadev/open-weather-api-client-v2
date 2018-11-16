package com.finleap.casestudy.feliperocha.openweatherapiclient.controller.v1;

import com.finleap.casestudy.feliperocha.openweatherapiclient.domain.Weather;
import com.finleap.casestudy.feliperocha.openweatherapiclient.service.WeatherService;
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
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    @RequestMapping(path = "/{city}")
    ResponseEntity<Weather> getWeather(@PathVariable String city) {
        return ResponseEntity.ok(weatherService.getWeather(city));
    }

    @GetMapping
    @RequestMapping(path = "/{city}/forecast")
    ResponseEntity<List<Weather>> getForecastHistory(@PathVariable String city) {
        return ResponseEntity.ok(weatherService.getForecastHistory(city));
    }
}