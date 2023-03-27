package com.example.demo.application;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncMessageService {
    @Async
    public void myAsyncMethod() throws InterruptedException {
        System.out.println("Async method started");
        Thread.sleep(5000);
        System.out.println("Async method completed");
    }
}
