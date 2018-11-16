package com.finleap.casestudy.feliperocha.openweatherapiclient.controller.v1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CitiesWeatherInfoDTO {

    @JsonProperty("CitiesTemperature")
    private List<CityTemperatureDTO> citiesTemperatureDTO;
    @JsonProperty("cityWithHighestHumidity")
    private CityWithHighestHumidityDTO cityWithHighestHumidityDTO;
    @JsonProperty("cityWithHighestTemperature")
    private CityWithHighestTemperatureDTO cityWithHighestTemperatureDTO;

    public CitiesWeatherInfoDTO(List<CityTemperatureDTO> citiesTemperatureDTO, CityWithHighestHumidityDTO cityWithHighestHumidityDTO, CityWithHighestTemperatureDTO cityWithHighestTemperatureDTO) {
        this.citiesTemperatureDTO = citiesTemperatureDTO;
        this.cityWithHighestHumidityDTO = cityWithHighestHumidityDTO;
        this.cityWithHighestTemperatureDTO = cityWithHighestTemperatureDTO;
    }

    public List<CityTemperatureDTO> getCitiesTemperatureDTO() {
        return citiesTemperatureDTO;
    }

    public void setCityTemperatureDTO(List<CityTemperatureDTO> citiesTemperatureDTO) {
        this.citiesTemperatureDTO = citiesTemperatureDTO;
    }

    public CityWithHighestHumidityDTO getCityWithHighestHumidityDTO() {
        return cityWithHighestHumidityDTO;
    }

    public void setCityWithHighestHumidityDTO(CityWithHighestHumidityDTO cityWithHighestHumidityDTO) {
        this.cityWithHighestHumidityDTO = cityWithHighestHumidityDTO;
    }

    public CityWithHighestTemperatureDTO getCityWithHighestTemperatureDTO() {
        return cityWithHighestTemperatureDTO;
    }

    public void setCityWithHighestTemperatureDTO(CityWithHighestTemperatureDTO cityWithHighestTemperatureDTO) {
        this.cityWithHighestTemperatureDTO = cityWithHighestTemperatureDTO;
    }
}
