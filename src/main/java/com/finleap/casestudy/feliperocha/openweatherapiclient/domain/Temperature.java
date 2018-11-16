package com.finleap.casestudy.feliperocha.openweatherapiclient.domain;

public class Temperature {
    private String average;
    private String min;
    private String max;

    public String getAverage() {
        return average;
    }

    public void setAverage(String current) {
        this.average = current;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }
}
