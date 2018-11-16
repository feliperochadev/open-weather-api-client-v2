package com.finleap.casestudy.feliperocha.openweatherapiclient.controller.v1;

import com.finleap.casestudy.feliperocha.openweatherapiclient.domain.Forecast;
import com.finleap.casestudy.feliperocha.openweatherapiclient.service.ForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.finleap.casestudy.feliperocha.openweatherapiclient.controller.BaseControllerHeader.API_V1;
import static com.finleap.casestudy.feliperocha.openweatherapiclient.controller.BaseControllerHeader.APPLICATION_JSON;

@RestController
@RequestMapping(path = "/forecast", produces = { APPLICATION_JSON }, headers = { API_V1 })
public class ForecastController {

    private final ForecastService forecastService;

    @Autowired
    ForecastController(ForecastService forecastService) {
        this.forecastService = forecastService;
    }

    @GetMapping
    @RequestMapping(path = "/{city}")
    ResponseEntity<Forecast> getForecast(@PathVariable String city) {
        return ResponseEntity.ok(forecastService.getForecast(city));
    }
}
