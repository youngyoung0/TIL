package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // OrderServiceImpl이 DiscoutPolicy 인터페이스 뿐만 아니라 FixDiscountPolicy인 구현체 클래스도 의존하고 있다. DIP 의존관계 역전 원칙 위반
    // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    // FixDiscountPolicy를 RateDiscountPolicy로 변경하는 순간 OrderServiceimpl의 소스코드도 함께 변경해야 한다. OCP 개방 폐쇄 원칙 위반
    // private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    private DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
