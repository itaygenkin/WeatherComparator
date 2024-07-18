package com.itay.weather.processor.dto;

import java.time.LocalDateTime;

public class WeatherDataDto {
    private String source;
    private LocalDateTime time;
    private Float temperature;
    private Float humidity;
}
