package com.finleap.casestudy.feliperocha.openweatherapiclient.controller.v1.dto;

public class CityWithHighestHumidityDTO {
    private String name;
    private String humidityPercentage;

    public CityWithHighestHumidityDTO(String name, String humidityPercentage) {
        this.name = name;
        this.humidityPercentage = humidityPercentage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHumidityPercentage() {
        return humidityPercentage;
    }

    public void setHumidityPercentage(String humidityPercentage) {
        this.humidityPercentage = humidityPercentage;
    }
}
