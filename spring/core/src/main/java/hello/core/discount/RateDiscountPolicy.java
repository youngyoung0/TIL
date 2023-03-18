package hello.core.discount;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy{

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            int discountPercent = 10;
            return (price * discountPercent) / 100;
        }
        return 0;
    }
}
