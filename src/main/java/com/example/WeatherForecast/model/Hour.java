package com.example.WeatherForecast.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Hour {
    public String temp_c;
    public Condition conditon;
    public String wind_mph;
    public String wind_degree;
    public String humidity;
    public String cloud;

}
