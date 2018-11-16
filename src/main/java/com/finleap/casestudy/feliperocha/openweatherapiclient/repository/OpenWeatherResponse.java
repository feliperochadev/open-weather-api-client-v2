package com.finleap.casestudy.feliperocha.openweatherapiclient.repository;

import java.util.List;
import java.util.Map;

public class OpenWeatherResponse {
    private String dt;
    private List<Map<String, Object>> weather;
    private Map<String, Object> main;
    private Map<String, Object> wind;
    private Map<String, Object> clouds;
    private String name;

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public List<Map<String, Object>> getWeather() {
        return weather;
    }

    public void setWeather(List<Map<String, Object>> weather) {
        this.weather = weather;
    }

    public Map<String, Object> getMain() {
        return main;
    }

    public void setMain(Map<String, Object> main) {
        this.main = main;
    }

    public Map<String, Object> getWind() {
        return wind;
    }

    public void setWind(Map<String, Object> wind) {
        this.wind = wind;
    }

    public Map<String, Object> getClouds() {
        return clouds;
    }

    public void setClouds(Map<String, Object> clouds) {
        this.clouds = clouds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
