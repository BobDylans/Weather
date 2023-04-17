package com.example.WeatherForecast.form;

import lombok.Data;
@Data
public class CurrentWeatherForm {
    public String icon;
    public String name;
    public String country;
    public String day;
    public String text;
    public String temperature;
    public String wind_mph;
    public String wind_degree;
    public String wind_dir;
    public String humidity;
    public String cloud;
    
}
