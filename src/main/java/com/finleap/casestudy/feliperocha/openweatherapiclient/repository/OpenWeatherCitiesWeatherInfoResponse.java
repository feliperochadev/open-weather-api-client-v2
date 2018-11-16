package com.finleap.casestudy.feliperocha.openweatherapiclient.repository;

import java.util.List;

public class OpenWeatherCitiesWeatherInfoResponse {
    private List<OpenWeatherResponse> list;

    public List<OpenWeatherResponse> getList() {
        return list;
    }

    public void setList(List<OpenWeatherResponse> list) {
        this.list = list;
    }
}
