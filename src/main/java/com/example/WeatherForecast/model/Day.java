package com.example.WeatherForecast.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Day {
    public String maxtemp_c;
    public String mintemp_c;
    public String avgtemp_c;
     public String avgtemp_f;
    public String maxwind_mph;
    public String daily_will_it_rain;
    public Condition condition;
}
