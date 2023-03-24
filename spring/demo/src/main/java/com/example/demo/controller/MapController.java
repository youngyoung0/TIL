package com.example.demo.controller;

import com.example.demo.infrastructure.config.MapConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("map")
public class MapController {

    private final MapConfig mapConfig;

    @GetMapping("config")
    public ResponseEntity<String> mapConfig(){
        System.out.println(mapConfig);
        return new ResponseEntity<>("mapConfig", HttpStatus.OK);
    }
}
