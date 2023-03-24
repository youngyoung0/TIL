package com.example.demo.config;

import com.example.demo.infrastructure.config.MapConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;


//@ContextConfiguration(classes= MapConfig.class)
@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestPropertySource(locations = "classpath:application.yaml")
public class MapConfigTest {

    @Autowired
    MapConfig mapConfig;

    @Test
    @DisplayName("Application 값 가져오기")
    void configValue(){
        System.out.println(mapConfig);
    }
}
