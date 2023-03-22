package com.example.demo.config;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes=MapConfig.class)
@TestPropertySource(properties = {"spring.config.location= = classpath:application.yaml"})
public class MapConfigTest {

    @Autowired
    MapConfig mapConfig;

    @Test
    @DisplayName("Application 값 가져오기")
    void configValue(){
        System.out.println(mapConfig);
    }
}
