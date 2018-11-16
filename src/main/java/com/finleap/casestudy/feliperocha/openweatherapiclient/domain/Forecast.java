package com.finleap.casestudy.feliperocha.openweatherapiclient.domain;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.time.LocalDateTime;
import java.util.List;

@JsonRootName("Forecast")
public class Forecast {

    private Temperature temperature;
    private String atmosphericPressurehPa;
    private String humidityPercentage;
    private List<String> weatherDescriptions;
    private String windSpeed;
    private String cloudinessPercentage;

    private LocalDateTime dateTime;

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public List<String> getWeatherDescriptions() {
        return weatherDescriptions;
    }

    public void setWeatherDescriptions(List<String> weatherDescriptions) {
        this.weatherDescriptions = weatherDescriptions;
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

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getCloudinessPercentage() {
        return cloudinessPercentage;
    }

    public void setCloudinessPercentage(String cloudinessPercentage) {
        this.cloudinessPercentage = cloudinessPercentage;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
