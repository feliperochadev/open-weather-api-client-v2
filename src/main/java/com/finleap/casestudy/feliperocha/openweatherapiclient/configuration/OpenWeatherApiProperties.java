package com.finleap.casestudy.feliperocha.openweatherapiclient.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.NotNull;
import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "openweatherapi")
public class OpenWeatherApiProperties {
    @NotNull
    private String host;

    @NotNull
    private String apiId;

    @NotNull
    private String defaultUnit;

    @NotNull
    private List<String> availableUnities;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getApiId() {
        return apiId;
    }

    public void setApiId(String apiId) {
        this.apiId = apiId;
    }

    public String getDefaultUnit() {
        return defaultUnit;
    }

    public void setDefaultUnit(String defaultUnit) {
        this.defaultUnit = defaultUnit;
    }

    public List<String> getAvailableUnities() {
        return availableUnities;
    }

    public void setAvailableUnities(List<String> availableUnities) {
        this.availableUnities = availableUnities;
    }
}
