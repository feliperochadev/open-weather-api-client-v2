package com.finleap.casestudy.feliperocha.openweatherapiclient.service

import com.finleap.casestudy.feliperocha.openweatherapiclient.configuration.CityProperties
import com.finleap.casestudy.feliperocha.openweatherapiclient.configuration.OpenWeatherApiProperties
import com.finleap.casestudy.feliperocha.openweatherapiclient.controller.v1.dto.WeatherForecastDTO
import com.finleap.casestudy.feliperocha.openweatherapiclient.domain.City
import com.finleap.casestudy.feliperocha.openweatherapiclient.domain.Temperature
import com.finleap.casestudy.feliperocha.openweatherapiclient.domain.Weather
import com.finleap.casestudy.feliperocha.openweatherapiclient.exception.CityNotInTheListException
import com.finleap.casestudy.feliperocha.openweatherapiclient.mapper.WeatherMapper
import com.finleap.casestudy.feliperocha.openweatherapiclient.repository.OpenWeatherCitiesWeatherInfoResponse
import com.finleap.casestudy.feliperocha.openweatherapiclient.repository.OpenWeatherForecastResponse
import com.finleap.casestudy.feliperocha.openweatherapiclient.repository.OpenWeatherResponse
import com.finleap.casestudy.feliperocha.openweatherapiclient.repository.WeatherRepository
import spock.lang.Specification

import java.time.LocalDateTime

class WeatherServiceUnitTest extends Specification {

    private WeatherService service
    private WeatherRepository weatherRepository
    private OpenWeatherApiProperties openWeatherApiProperties
    private WeatherMapper weatherMapper
    private CityProperties cityProperties

    void setup() {
        weatherRepository = Mock(WeatherRepository)
        openWeatherApiProperties = new OpenWeatherApiProperties(apiId: 1, defaultUnit: "metric")
        weatherMapper = Mock(WeatherMapper)
        cityProperties = new CityProperties()
        cityProperties.cities = [:]
        cityProperties.cities.put("berlin", "1")
        cityProperties.cities.put("paris", "2")
        cityProperties.cities.put("london", "3")
        service = new WeatherService(weatherRepository, openWeatherApiProperties, weatherMapper, cityProperties)
    }

    def "customer gets weather for a city"() {
        given:
        def city = "berlin"

        when:
        def result = service.getWeather(city)

        then:
        1 * weatherRepository.getWeather(_ as String, _ as String, _ as String) >> new OpenWeatherResponse()
        1 * weatherMapper.toWeather(_ as OpenWeatherResponse) >> new Weather(temperature: new Temperature(average: 20))
        result
        result.temperature.average == "20"
    }

    def "customer gets weather forecast for a city"() {
        given:
        def city = "berlin"

        when:
        def result = service.getForecast(city)

        then:
        1 * weatherRepository.getForecast(_ as String, _ as String, _ as String) >> new OpenWeatherForecastResponse(list: [new OpenWeatherResponse()])
        1 * weatherMapper.toForecast(_ as List<OpenWeatherResponse>) >> [
                new WeatherForecastDTO(humidityPercentage: "100"),
                new WeatherForecastDTO(atmosphericPressurehPa: "1000"),
                new WeatherForecastDTO(temperature: new Temperature(max: "30"), dateTime: LocalDateTime.now())
        ]
        result
        result.size() == 3
        result.findAll { it.humidityPercentage == "100" }.size() == 1
        result.findAll { it.atmosphericPressurehPa == "1000" }.size() == 1
        result.findAll { it.temperature?.max == "30" }.size() == 1
    }

    def "customer gets weather info for 3 cities"() {
        when:
        def result = service.getCitiesWeatherInfo()

        then:
        1 * weatherRepository.getCitiesWeatherInfo(_ as String, _ as String, _ as String) >>
                new OpenWeatherCitiesWeatherInfoResponse(list: [new OpenWeatherResponse()])
        1 * weatherMapper.toCities(_ as List<OpenWeatherResponse>) >> [
                new City(name: "berlin", weather: new Weather(temperature: new Temperature(max: "30", average: "25"), humidityPercentage: "100")),
                new City(name: "paris", weather: new Weather(temperature: new Temperature(max: "25", average: "20"), humidityPercentage: "90")),
                new City(name: "london", weather: new Weather(temperature: new Temperature(max: "35", average: "33"), humidityPercentage: "80")),
        ]
        result
        result.cityWithHighestHumidityDTO.name == "berlin"
        result.cityWithHighestHumidityDTO.humidityPercentage == "100"
        result.cityWithHighestTemperatureDTO.name == "london"
        result.cityWithHighestTemperatureDTO.maxTemperature == "35"
        result.citiesTemperatureDTO.find { it.average == "20" }.name == "paris"
    }

    def "throws CityNotInTheListException"() {
        given:
        def city = "rome"

        when:
        service.getWeather(city)

        then:
        thrown CityNotInTheListException
    }
}
