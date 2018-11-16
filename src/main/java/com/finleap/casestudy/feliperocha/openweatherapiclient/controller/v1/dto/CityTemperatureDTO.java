package com.finleap.casestudy.feliperocha.openweatherapiclient.controller.v1.dto;

public class CityTemperatureDTO {
    public CityTemperatureDTO(String name, String average) {
        this.name = name;
        this.average = average;
    }

    private String name;
    private String average;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }
}
