package com.example.stock.service;

import com.example.stock.domain.Stock;
import com.example.stock.repository.StockRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PessimisticLockStockService {
    private StockRepository stockRepository;

    public PessimisticLockStockService(StockRepository stockRepository){
        this.stockRepository = stockRepository;
    }

    @Transactional
    public void decrease(Long id, Long quantity){
        Stock stock = stockRepository.findByIdWithPessimisticLock(id);

        stock.decrease(id);
    }

    /**
     * Pessimistic Lock
     * 실제로 데이터에 Lock을 걸어서 정합성을 맞추는 방법입니다.
     * Exclusive lock을 걸게되면 다른 트랜잭션에서는 lock이 해제되기 전에 데이터를 가져갈 수 없게 됩니다.
     * 데드락이 걸리 수 있기 때문에 주의하여 사용하여야 합니다.
     *
     * 예시 서버가 여러개 있을때 서버 1일 락을걸로 사용중일동안에는 다른 서버에서는 데이터를 가져올 수 없습니다.
     *
     * 장점
     * 충돌이 빈번하게 일어난다면 Optimistic Lock보다 성능이 좋을 수 있습니다.
     * Lock을 통해서 update를 제어하기 때문에 데이터 접합성을 어느정도 보장됩니다.
     *
     * 단점
     * 별도의 락을 잡기 때문에 성능 저하가 일어 납니다.
     */
}
