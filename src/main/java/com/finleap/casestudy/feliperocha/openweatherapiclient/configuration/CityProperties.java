package com.finleap.casestudy.feliperocha.openweatherapiclient.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.NotNull;
import java.util.Map;

@Configuration
@ConfigurationProperties("application")
public class CityProperties {

    @NotNull
    private Map<String, String> cities;

    public Map<String, String> getCities() {
        return cities;
    }

    public void setCities(Map<String, String> cities) {
        this.cities = cities;
    }
}
