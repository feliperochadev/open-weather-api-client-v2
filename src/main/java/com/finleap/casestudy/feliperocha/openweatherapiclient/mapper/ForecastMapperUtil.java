package com.finleap.casestudy.feliperocha.openweatherapiclient.mapper;

import org.mapstruct.Qualifier;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.stream.Collectors;

@Component
public class ForecastMapperUtil {

    private static final String WEATHER_DESCRIPTION_KEY = "description";
    private static final String TEMPERATURE = "temp";
    private static final String MIN_TEMPERATURE = "temp_min";
    private static final String MAX_TEMPERATURE = "temp_max";
    private static final String HUMIDITY_PERCENTAGE = "humidity";
    private static final String ATMOSPHERIC_PRESSURE_HPA = "pressure";
    private static final String WIND_SPEED = "speed";
    private static final String CLOUDINESS_PERCENTAGE = "all";

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface DateTime {
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface Temperature {
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public static @interface MaxTemperature {
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public static @interface MinTemperature {
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public static @interface AtmosphericPressurehPa {
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public static @interface HumidityPercentage {
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public static @interface WeatherDescriptions {
    }

    @Temperature
    public String temperature(Map<String, Object> in) {
        return in.get(TEMPERATURE).toString();
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public static @interface WindSpeed {
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public static @interface CloudinessPercentage {
    }

    @DateTime
    public LocalDateTime maxTemperature(String dateTime) {
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(Long.parseLong(dateTime)), TimeZone.getDefault().toZoneId());
    }

    @MaxTemperature
    public String maxTemperature(Map<String, Object> in) {
        return in.get(MAX_TEMPERATURE).toString();
    }

    @MinTemperature
    public String minTemperature(Map<String, Object> in) {
        return in.get(MIN_TEMPERATURE).toString();
    }

    @AtmosphericPressurehPa
    public String atmosphericPressurehPa(Map<String, Object> in) {
        return in.get(ATMOSPHERIC_PRESSURE_HPA).toString();
    }

    @HumidityPercentage
    public String humidityPercentage(Map<String, Object> in) {
        return in.get(HUMIDITY_PERCENTAGE).toString();
    }

    @WindSpeed
    public String windSpeed(Map<String, Object> in) {
        return in.get(WIND_SPEED).toString();
    }

    @CloudinessPercentage
    public String cloudinessPercentage(Map<String, Object> in) {
        return in.get(CLOUDINESS_PERCENTAGE).toString();
    }

    @WeatherDescriptions
    public List<String> weatherDescriptions(List<Map<String, Object>> in) {
        return in.stream()
                .map(m -> m.get(WEATHER_DESCRIPTION_KEY).toString())
                .collect(Collectors.toList());
    }
}
