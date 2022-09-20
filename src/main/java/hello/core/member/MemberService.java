package hello.core.member;

public interface MemberService {
    //회원 가입과 회원 조회 기능이 있다.
    void join(Member member); // 회원 가입

    Member findByMember(Long memberId); // 회원 조회
}
