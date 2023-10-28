package com.example.WeatherForecast.config;

import com.example.WeatherForecast.form.CurrentWeatherForm;
import com.example.WeatherForecast.service.WeatherService;
import com.example.WeatherForecast.service.WeatherServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfig {
    
    @Bean
    public WebClient getWebClient(){
        return WebClient.builder()
           // .baseUrl("https://api.openweathermap.org/data/2.5/weather") //openweather
              .baseUrl("http://api.weatherapi.com/v1/forecast.json")    //weatherapi
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build();

    }
    
    @Bean
    public CurrentWeatherForm getCurrentWeatherForm(){
        return new CurrentWeatherForm();
    }
    
    @Bean
    public WeatherService getWeatherService(){
        return new WeatherServiceImpl();
    }
}
