package com.example.api.service;

import com.example.api.producer.CouponCreateProducer;
import com.example.api.repository.CouponCountRepository;
import com.example.api.repository.CouponRepository;
import org.springframework.stereotype.Service;

@Service
public class ApplyService {
    private final CouponRepository couponRepository;

    private final CouponCountRepository couponCountRepository;

    private final CouponCreateProducer couponCreateProducer;

    public ApplyService(CouponRepository couponRepository, CouponCountRepository couponCountRepository, CouponCreateProducer couponCreateProducer){
        this.couponRepository = couponRepository;
        this.couponCountRepository = couponCountRepository;
        this.couponCreateProducer = couponCreateProducer;
    }

    public void apply(Long userId){
        // redis incr key:value 싱글 스레드 기반으로 동작
        Long count = couponCountRepository.increment();
        System.out.println(count);
        if(count > 100){
            return;
        }
        couponCreateProducer.create(userId); // 토픽에 유저아이디를 전송
        /**
         * 싱글 스레드로 작업을 진행하게 된다면 레이스 컨디션이 발생하지 않습니다.
         * 하지만 1번사용자가 10:01에 쿠폰 발급을 완료하게 되면 다른 사용자는 10:01분 이후에 쿠폰 발급이 이뤄 지기 때문에 원하는 로직이랑 맞지 않습니다.
         */
    }
}
