package com.finleap.casestudy.feliperocha.openweatherapiclient.domain;

import java.util.List;

public class City {

    private String name;
    private List<Weather> weathers;

    public List<Weather> getWeathers() {
        return weathers;
    }

    public void setWeathers(List<Weather> weathers) {
        this.weathers = weathers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
