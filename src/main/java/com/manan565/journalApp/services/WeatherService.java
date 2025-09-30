package com.manan565.journalApp.services;

import com.manan565.journalApp.api.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class WeatherService {

    private static final String  apiKey="fb0277c4ef59ac8060bf34a8587fe77e";
    private static final String API = "http://api.weatherstack.com/current?access_key=API_KEY&query=CITY";
    @Autowired
    private RestTemplate restTemplate;

    public WeatherResponse getWeather(String city){
        String finalAPI = API.replace("CITY", city).replace("API_KEY",apiKey);
        ResponseEntity<WeatherResponse> response =restTemplate.exchange(finalAPI, HttpMethod.GET,null, WeatherResponse.class);
        WeatherResponse body = response.getBody();
        return body;

    }
}
