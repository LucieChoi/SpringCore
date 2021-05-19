package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    // MemberService memberService = new MemberServiceImpl();
    MemberService memberService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join(){
        //given 이런 환경이 주어졌을 때
        Member member = new Member(1L, "memberA", Grade.VIP);
        //when 이런 동작을 하면
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        //then 이렇게 됨. 검증
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
