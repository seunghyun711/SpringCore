package hello.core.member;

public class MemberServiceImpl implements MemberService{

    // 가입하고 회원 찾으려면 MemberRepository인터페이스가 필요하다.
    /*
     MemberRepository라는 인터페이스를 의존하면서 구현체인 MemoryMemberRepository까지 의존한다.
     즉, 추상화와 구체화 모두에 의존한다. -> DIP 위반
     */
    private final MemberRepository memberRepository; // 인터페이스에만 의존, 즉 추상화에만 의존한다. 구체적인 것은 AppConfig에서 처리한다.

    // 생성자 주입
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findByMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
