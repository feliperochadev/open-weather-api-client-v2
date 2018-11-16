package com.finleap.casestudy.feliperocha.openweatherapiclient.domain;

public class Temperature {
    private String current;
    private String min;
    private String max;

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
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
