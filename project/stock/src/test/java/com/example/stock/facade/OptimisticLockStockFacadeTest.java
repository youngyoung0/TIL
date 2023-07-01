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
class OptimisticLockStockFacadeTest {
    @Autowired
    private OptimisticLockStockFacade optimisticLockStockFacade;

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
    public void 동시에_100개의_요청_Optimistic_Lock() throws InterruptedException {
        int threadCount = 100;
        ExecutorService executorService = Executors.newFixedThreadPool(32);
        CountDownLatch latch = new CountDownLatch(threadCount);

        for(int i = 0; i <threadCount; i++){
            executorService.submit(() -> {
                try{
                    optimisticLockStockFacade.decrease(1L, 1L);
                } catch (InterruptedException e){
                    throw new RuntimeException(e);
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
         * 실제로 Lock을 이용하지 않고 버전을 이용함으로써 정합성을 맞추는 방법입니다.
         * 먼저 데이터를 읽은 후에 update를 수행할 때 현재 내가 읽은 버전이 맞는지 확인하여 업데이트 합니다.
         * 내가 읽은 버전에서 수정사항이 생겼을 경우에는 application에서 다시 읽은후에 작업을 수행해야 합니다.
         *
         * 데이터를 수정할때 버전을 명시하기 때문에 버전을 비교해서 데이터 수정에 반영합니다.
         *
         * 장점
         * 락을 별도로 잡지 않으므로 Pessimistic Lock보다 성능상 이점이 있습니다.
         *
         * 단점
         * update 로직이 실패했을대 로직을 개발자가 작성해야힙나다.
         *
         */

    }
}