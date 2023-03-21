package com.example.demo.config;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:application.yaml")
@Getter
@Setter
@ToString
public class MapConfig {
    @Value("${map.kakao}")
    private String kakaoKey;
    @Value("${map.naver}")
    private String naverKey;
}
