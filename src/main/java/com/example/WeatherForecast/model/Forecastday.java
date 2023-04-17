package com.example.WeatherForecast.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Forecastday {
    public String date; //2023-02-22
    public Day day;
    public List<Hour> hour;
}
