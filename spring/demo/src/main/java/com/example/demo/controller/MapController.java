package com.example.demo.controller;

import com.example.demo.application.AsyncMessageService;
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
    private final AsyncMessageService asyncMessageService;

    @GetMapping("config")
    public ResponseEntity<String> mapConfig(){
        System.out.println(mapConfig);
        return new ResponseEntity<>("mapConfig", HttpStatus.OK);
    }

    @GetMapping("async")
    public void async() throws InterruptedException {
        System.out.println("Calling asynchronous method");
        asyncMessageService.myAsyncMethod();
        System.out.println("Asynchronous method call returned");
    }
}
