package com.finleap.casestudy.feliperocha.openweatherapiclient.controller.v1

import com.finleap.casestudy.feliperocha.openweatherapiclient.controller.v1.dto.CitiesWeatherInfoDTO
import com.finleap.casestudy.feliperocha.openweatherapiclient.controller.v1.dto.CityWithHighestHumidityDTO
import com.finleap.casestudy.feliperocha.openweatherapiclient.controller.v1.dto.CityWithHighestTemperatureDTO
import com.finleap.casestudy.feliperocha.openweatherapiclient.domain.Weather
import com.finleap.casestudy.feliperocha.openweatherapiclient.service.WeatherService
import org.springframework.http.HttpStatus
import spock.lang.Specification

class WeatherControllerUnitTest extends Specification {

    private WeatherController controller
    private WeatherService weatherService

    void setup() {
        weatherService = Mock(WeatherService)
        controller = new WeatherController(weatherService)
    }

    void "get weather endpoint"() {
        when:
        def result = controller.getWeather("Berlin")

        then:
        1 * weatherService.getWeather("Berlin") >> new Weather()
        result.statusCode == HttpStatus.OK
    }

    void "get weather forecast endpoint"() {
        when:
        def result = controller.getForecast("Berlin")

        then:
        1 * weatherService.getForecast("Berlin") >> []
        result.statusCode == HttpStatus.OK
    }

    void "get weather info for cities"() {
        when:
        def result = controller.getCitiesWeatherInfo()

        then:
        1 * weatherService.getCitiesWeatherInfo() >>
                new CitiesWeatherInfoDTO([],
                        new CityWithHighestHumidityDTO("test", "100"),
                        new CityWithHighestTemperatureDTO("test", "30")
                )
        result.statusCode == HttpStatus.OK
    }
}
