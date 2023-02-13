package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        MemberService memberService = new MemberServiceImpl();

        // 스프링 컨테이너 적용
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class); // AppConfig에 있는 설정정보를 가지고 bean 붙은 객체드들을 스프링 컨테이너에 등록한다.
        MemberService memberService = ac.getBean("memberService", MemberService.class);// MemberService가 반환타입인 memberServiec()메서드를 꺼냄
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findByMember(1L); // id가 1인 회원 찾기
        // 아래 코드는 모두 memberA가 출력된다. 이것은 순수한 자바로만 개발을 한 것이다.
        System.out.println("new member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());

    }
}
