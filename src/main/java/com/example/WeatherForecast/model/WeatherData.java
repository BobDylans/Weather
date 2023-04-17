package com.example.WeatherForecast.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class WeatherData{
    public Location location;
    public Current current;
    public Forecast forecast;
}