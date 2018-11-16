package com.finleap.casestudy.feliperocha.openweatherapiclient.controller.v1.dto;

public class CityWithHighestTemperatureDTO {
    public CityWithHighestTemperatureDTO(String name, String maxTemperature) {
        this.name = name;
        this.maxTemperature = maxTemperature;
    }

    private String name;
    private String maxTemperature;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(String maxTemperature) {
        this.maxTemperature = maxTemperature;
    }
}
