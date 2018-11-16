package com.finleap.casestudy.feliperocha.openweatherapiclient.repository;

import java.util.List;

public class OpenWeatherCitiesWeatherInfoResponse {
    private List<OpenWeatherWeatherResponse> list;

    public List<OpenWeatherWeatherResponse> getList() {
        return list;
    }

    public void setList(List<OpenWeatherWeatherResponse> list) {
        this.list = list;
    }
}
