package com.example.stock.facade;

import com.example.stock.domain.Stock;
import com.example.stock.repository.StockRepository;
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
class NamedLockStockFacadeTest {
    @Autowired
    private NamedLockStockFacade namedLockStockFacade;

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
    public void 동시에_100개의_요청_Named_Lock() throws InterruptedException {
        int threadCount = 100;
        ExecutorService executorService = Executors.newFixedThreadPool(32);
        CountDownLatch latch = new CountDownLatch(threadCount);

        for(int i = 0; i <threadCount; i++){
            executorService.submit(() -> {
                try{
                    namedLockStockFacade.decrease(1L, 1L);
                } finally {
                    latch.countDown();
                }
            });
        }

        latch.await();

        Stock stock = stockRepository.findById(1L).orElseThrow();

        // 100 - (1 * 100) = 0
        assertThat(stock.getQuantity()).isEqualTo(0);

        /**
         * 이름을 가진 metadata locking입니다. 이름을 가진 lock을 획득한 후 해제할 때까지 다르ㅏㄴ 세션은 이 lock을 획득할 수 없도록 합니다.
         * 주의할점으로는 trasation이 종료될 때 lock 자동으로 해제되지 않습니다. 별도의 명령어로 해제를 수행해주거나 선점시간이 끝나야 해제됩니다.
         *
         * transation이 끝나도 락이 끝나지 않기 때문에별도의 락을 해제하거나 선점시간이 끝나야지 락이 해제됩니다.
         *
         * Named Lock은 주로 분산 락을 구현할때 사용
         * 데이터 삽입시 정확성 하기위해서도 사용
         */

    }
}