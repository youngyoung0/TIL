package com.example.stock.service;

import com.example.stock.domain.Stock;
import com.example.stock.repository.StockRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StockService {

    private StockRepository stockRepository;

    public StockService(StockRepository stockRepository){
        this.stockRepository = stockRepository;
    }

//    @Transactional
    public synchronized void decrease(Long id, Long quantity){
        // get stock
        // 재고 감소
        // 저장

        Stock stock = stockRepository.findById(id).orElseThrow();

        stock.decrease(quantity);

        stockRepository.saveAndFlush(stock);

        /**
         * synchronized와 @Transactional 같이 사용하면 문제점
         * Synchronized를 사용하는 이유는 해당 메서드를 한 쓰레드에서만 돌리기 위해서 이다.
         * 하지만, 트랜잭션이 같이 정의가 되어있다면 첫 번째 쓰레드가 끝나기 전 두 번째 쓰레드가 발동할 수도 있다.
         *
         * 문제점
         * Synchronized 각 프로세스 안에서만 보장됩니다.
         * 서버가 여러개 있을경우 사용할 수 없습니다.
         */
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public synchronized void decreaseNamedLock(Long id, Long quantity){

        Stock stock = stockRepository.findById(id).orElseThrow();

        stock.decrease(quantity);

        stockRepository.saveAndFlush(stock);
    }
}
