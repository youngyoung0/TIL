package studyJPA.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import studyJPA.demo.domain.Member;
import studyJPA.demo.repository.MemberRepository;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MemberService memberService;
    @Autowired
    EntityManager em;

    @Test
    public void 회원가입() throws Exception{
        //given -> 이런게 주워지면
        Member member = new Member();
        member.setName("kim");

        //when-> 이렇게 해라
        Long saveId = memberService.join(member);

        //then -> 이렇게 됬어
        em.flush();
        assertEquals(member, memberRepository.findOne(saveId));
    }

    @Test(expected=IllegalStateException.class)
    public void 중복_회원_에러() throws Exception{
        //given
        Member member1  = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");

        //when
        memberService.join(member1);
        memberService.join(member2); // 예외가 발생해야 한다.



        //then
        fail("예외가 발생해아한다.");

    }
}