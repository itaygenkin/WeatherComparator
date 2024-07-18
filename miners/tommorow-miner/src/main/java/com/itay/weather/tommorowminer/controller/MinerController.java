package com.itay.weather.tommorowminer.controller;

import com.itay.weather.tommorowminer.service.MinerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public class MinerController {


    private final MinerService minerService;

    public MinerController(MinerService minerService) {
        this.minerService = minerService;
    }

    @GetMapping
    public ResponseEntity<Void> fetchData() {
        try {
            minerService.fetchAndSendData();
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}