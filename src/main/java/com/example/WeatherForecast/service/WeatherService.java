package com.example.WeatherForecast.service;

import com.example.WeatherForecast.form.CurrentWeatherForm;
import com.example.WeatherForecast.form.WeekdayWeatherForm;
import java.util.List;


public interface WeatherService {
    public void getCityName(String cityAndCountryName);
    public void getAPI();
    public List<WeekdayWeatherForm> getWeekdayWeatherForm();
    public CurrentWeatherForm getCurrentWeatherForm();
}
