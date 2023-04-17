package com.example.WeatherForecast.form;

import lombok.Data;

@Data
public class WeekdayWeatherForm {
    String day;
    String icon;
    String text;
    String temperature;
}
