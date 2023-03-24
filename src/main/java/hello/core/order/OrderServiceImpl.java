package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    //MemberRepository에서 회원을 찾아야하기 때문에 MemeberRepository필요
    private final MemberRepository memberRepository;
    // FixDiscountPolicy, RateDiscountPolicy는 구현 클래스인데 이걸 의존하고 있다. -> DIP 위반
    // 클라이언트 코드인 OrderServiceImpl은 할인 정책 변경에 따라 코드를 변경해야 한다. -> OCP 위반
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    private final DiscountPolicy discountPolicy; // 인터페이스에만 의존한다.

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        /*
        OrderServiceImpl에서는 할인에 대한 부분은 discountPolicy애 역할을 넘기고 결과만 받게끔 설계가 되었다. 이는 단일 체계 원칙이 잘 지켜진 것이다.
         */
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
