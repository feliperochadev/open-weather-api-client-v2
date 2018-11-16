package com.finleap.casestudy.feliperocha.openweatherapiclient.controller.v1.dto;

import com.finleap.casestudy.feliperocha.openweatherapiclient.domain.Temperature;

import java.time.LocalDateTime;

public class WeatherForecastDTO {

    private Temperature temperature;
    private String atmosphericPressurehPa;
    private String humidityPercentage;
    private LocalDateTime dateTime;

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public String getAtmosphericPressurehPa() {
        return atmosphericPressurehPa;
    }

    public void setAtmosphericPressurehPa(String atmosphericPressurehPa) {
        this.atmosphericPressurehPa = atmosphericPressurehPa;
    }

    public String getHumidityPercentage() {
        return humidityPercentage;
    }

    public void setHumidityPercentage(String humidityPercentage) {
        this.humidityPercentage = humidityPercentage;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
