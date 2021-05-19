package hello.core.order;

import hello.core.discount.DiscountPolicy;
// import hello.core.discount.FixDiscountPolicy;
// import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    // private final MemberRepository memberRepository = new MemoryMemberRepository();
    // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    // private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy; // final이면 무조건 값이 할당되어야 해서 빨간줄.

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
        // 어떤 구현체가 들어올지는 얘는 모름. AppConfig만 알아.
        // 얘는 실행에만 집중하면 됨.

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
            // 아주 잘한 설계

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
