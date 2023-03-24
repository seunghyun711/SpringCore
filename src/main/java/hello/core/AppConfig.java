package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 애플리케이션 동작에 필요한 구현객체를 생성한다.
// AppConfig를 스프링으로 전환
@Configuration // 스프링 설정 정보임을 알린다.
public class AppConfig { // 의존관계는 여기에서 관리한다.
    /*
    스프링 컨테이너는 @Configuration이 붙은 AppConfig를 스프링 설정 정보로 사용한다.
    @Bean이라 적인 메서드를 모두 호출하여 반환된 객체를 스프링 컨테이너에 등록한다. 스프링 컨테이너에 등록된 객체를 스프링 빈이라 한다.
    스프링 빈은 @Bean이 붙은 메서드의 이름을 스프링 빈의 이름으로 사용한다.
     */
    @Bean // 스프링 컨테이너에 등록됨
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
