package com.itay.weather.backend.controller;

import com.itay.weather.backend.dto.WeatherDataDto;
import com.itay.weather.backend.service.BackendService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BackendController {

    private final BackendService backendService;

    public BackendController(BackendService backendService) {
        this.backendService = backendService;
    }

    @GetMapping("/weather-data")
    public ResponseEntity<List<WeatherDataDto>> getWeatherData() {
        List<WeatherDataDto> weatherData = backendService.getWeatherData();
        return ResponseEntity.ok(weatherData);
    }

    @PostMapping("/save-data")
    public ResponseEntity<Void> saveWeatherData(@RequestBody List<WeatherDataDto> weatherDataDtoList) {
        backendService.saveData(weatherDataDtoList);
        return ResponseEntity.noContent().build();
    }
}
