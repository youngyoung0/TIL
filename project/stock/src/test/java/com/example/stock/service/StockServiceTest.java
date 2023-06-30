package com.example.stock.service;

import com.example.stock.domain.Stock;
import com.example.stock.repository.StockRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class StockServiceTest {

    @Autowired
    private StockService stockService;

    @Autowired
    private StockRepository stockRepository;

    @BeforeEach
    public void before(){
        Stock stock = new Stock(1L, 100L);

        stockRepository.saveAndFlush(stock);
    }

    @AfterEach
    public void after(){
        stockRepository.deleteAll();
    }

    @Test
    public void stock_decrease(){
        stockService.decrease(1L, 1L);

        // 100 - 1 =99
        Stock stock = stockRepository.findById(1L).orElseThrow();

        assertThat(stock.getQuantity()).isEqualTo(99);
    }

    @Test
    public void 동시에_100개의_요청() throws InterruptedException {
        int threadCount = 100;
        ExecutorService executorService = Executors.newFixedThreadPool(32);
        CountDownLatch latch = new CountDownLatch(threadCount);

        for(int i = 0; i <threadCount; i++){
            executorService.submit(() -> {
                try{
                    stockService.decrease(1L, 1L);
                } finally {
                    latch.countDown();
                }
            });
        }

        latch.await();

        Stock stock = stockRepository.findById(1L).orElseThrow();

        // 100 - (1 * 100) = 0
        // 결과값 : false
        assertThat(stock.getQuantity()).isEqualTo(0);

        /**
         * 레이스 컨디션 발생 두개 이상의 프로세스 혹스 스레드가 공유 자원을 서로 사용하려고 경합하는 현상을 말합니다.
         * 동시에 공유 자원에 접근할 수 있으면 자원의 일관성을 해치는 결과가 발생할 수 있습니다.
         * 그래서 동시에 공유 자원에 접근할 수 없도록 상호 배제 조건을 만들어 놓는데, 여러 스레드가 하나의 스레드만이 차지할 수 있는
         * 락이 획득하기 위해 경합한다고 해서 붙여진 이름입니다.
         */
    }
}