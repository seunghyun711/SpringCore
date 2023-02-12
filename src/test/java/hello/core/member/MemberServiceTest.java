package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach // 테스트 실행전 실행되는 코드
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join(){
        //given
        Member member = new Member(1L,"memberA",Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findByMember(1L);

        //then 검증
        Assertions.assertThat(member).isEqualTo(findMember); // 조인한 member와 찾은 findMember와 같은지 테스트


    }
}
