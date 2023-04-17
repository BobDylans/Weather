package com.example.WeatherForecast.controller;

import com.example.WeatherForecast.form.WeekdayWeatherForm;
import com.example.WeatherForecast.form.CurrentWeatherForm;
import com.example.WeatherForecast.service.WeatherService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class WelcomeController {
    
    @Autowired
    WeatherService weatherService;
    
    @Autowired
    CurrentWeatherForm currentWeather;
    
    List<WeekdayWeatherForm> weekdayForm;
    
    @GetMapping("/")
    public String main(Model model) {
        return "welcome"; //view
    }

    @GetMapping("/ouput")   //weather forecast 7 day ahead
    public String getCurrentWeather(@RequestParam(value="city", required=true) String cityAndCountryName,
                                    Model model) {    
        
        weatherService.getCityName(cityAndCountryName);
        weatherService.getAPI();
        currentWeather = weatherService.getCurrentWeatherForm();
        weekdayForm = weatherService.getWeekdayWeatherForm();
    
        model.addAttribute("current",currentWeather);
        model.addAttribute("forms",weekdayForm);
        
        return "output";
    }

}