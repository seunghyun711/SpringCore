package hello.core.discount;

import hello.core.member.Member;

// 할인 정책 역할
public interface DiscountPolicy {

    /**
     * @return 할인 대상 금액 => 얼마 할인 해주는지를 리턴
     */

    int discount(Member member, int price);



}
