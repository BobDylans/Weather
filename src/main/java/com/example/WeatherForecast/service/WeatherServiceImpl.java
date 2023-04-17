package com.example.WeatherForecast.service;

import com.example.WeatherForecast.form.CurrentWeatherForm;
import com.example.WeatherForecast.form.WeekdayWeatherForm;
import com.example.WeatherForecast.model.WeatherData;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;


public class WeatherServiceImpl implements WeatherService{
    
    @Autowired
    WebClient webClient;
    
    @Autowired
    CurrentWeatherForm currentWeather;
  
    @Value("${API_Key}")
    public String API_Key;
    
    WeatherData weatherResult;
    String cityName;
    String days = "8";  //current day and 7 day ahead 
    String aqi = "no"; //air quality data  
    String alerts = "no";   
    String tempConcatCelcius_Faherit;
    
    
    @Override
    public void getCityName(String cityAndCountryName) {
        String[] cityAndCountryNameSplit = cityAndCountryName.split("-");      
        cityName = cityAndCountryNameSplit[0];
    }
    
    @Override
    public void getAPI(){
        weatherResult = webClient.get()
                               .uri(uriBuilder -> uriBuilder
                                        .queryParam("key", API_Key)
                                        .queryParam("q", cityName)
                                        .queryParam("days", days)
                                        .queryParam("aqi", aqi)
                                        .queryParam("alerts", alerts)                                      
                                        .build()) 
                               .accept(MediaType.APPLICATION_JSON)
                               .retrieve()
                               .bodyToMono(WeatherData.class)
                               .block();
    }

    @Override
    public CurrentWeatherForm getCurrentWeatherForm() {
        currentWeather.setIcon(weatherResult.current.condition.icon);
        currentWeather.setName(weatherResult.location.name);
        currentWeather.setCountry(weatherResult.location.country);
        currentWeather.setDay(weatherResult.forecast.forecastday.get(0).date);
        currentWeather.setText(weatherResult.current.condition.text);
        
        tempConcatCelcius_Faherit = weatherResult.current.temp_c
                    + "℃" + " / " + weatherResult.current.temp_f + "°F";
    
        currentWeather.setTemperature(tempConcatCelcius_Faherit);
        currentWeather.setWind_mph(weatherResult.current.wind_mph);
        currentWeather.setWind_degree(weatherResult.current.wind_degree);
        currentWeather.setWind_dir(weatherResult.current.wind_dir);
        currentWeather.setHumidity(weatherResult.current.humidity);
        currentWeather.setCloud(weatherResult.current.cloud);
        
        return currentWeather;
    }
    
    @Override
    public List<WeekdayWeatherForm> getWeekdayWeatherForm() {
        List<WeekdayWeatherForm> forms = new ArrayList<>();
        for(int i=1; i<=7; i++){
        
            WeekdayWeatherForm form = new WeekdayWeatherForm();
            form.setDay(weatherResult.forecast.forecastday.get(i).date);
            form.setIcon(weatherResult.forecast.forecastday.get(i).day.condition.icon);
            form.setText(weatherResult.forecast.forecastday.get(i).day.condition.text);
        
            tempConcatCelcius_Faherit = weatherResult.forecast.forecastday.get(i).day.avgtemp_c 
                    + "℃" + " / " + weatherResult.forecast.forecastday.get(i).day.avgtemp_f + "°F";
        
            form.setTemperature(tempConcatCelcius_Faherit);
            forms.add(form);
        }
        return forms;
    }
    
}
