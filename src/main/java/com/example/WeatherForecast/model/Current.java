package com.example.WeatherForecast.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Current {
    public String temp_c;
    public String temp_f;
    public Condition condition;
    public String wind_mph;
    public String wind_degree;
    public String wind_dir;
    public String humidity;
    public String cloud;
}
