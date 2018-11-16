package com.finleap.casestudy.feliperocha.openweatherapiclient.configuration;

import com.finleap.casestudy.feliperocha.openweatherapiclient.repository.WeatherRepository;
import feign.Feign;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RemoteServiceConfiguration {

    @Bean
    Decoder jacksonDecoder() {
        return new JacksonDecoder();
    }

    @Bean
    Encoder jacksonEncoder() {
        return new JacksonEncoder();
    }

    @Bean
    @Autowired
    WeatherRepository forecastRepository(OpenWeatherApiProperties properties, Decoder decoder, Encoder encoder) {
        return Feign.builder()
                .decoder(decoder)
                .encoder(encoder)
                .target(WeatherRepository.class, properties.getHost());
    }
}
