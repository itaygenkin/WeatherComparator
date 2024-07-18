package com.itay.weather.openweatherminer.service;

import com.itay.weather.openweatherminer.dto.WeatherDataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MinerService {

    @Autowired
    private KafkaTemplate<String, WeatherDataDto> kafkaTemplate;

    public void fetchAndSendData() {
        WeatherDataDto data = fetchDataFromApi();
        sendDataToKafka(data);
    }

    private WeatherDataDto fetchDataFromApi() {
        String openApi = "";
        // TODO: implement
        return null;
    }

    private void sendDataToKafka(WeatherDataDto weatherData) {
        kafkaTemplate.send("weather-data", weatherData);
    }
}
