package start.hellospring.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import start.hellospring.domain.Member;
import start.hellospring.repository.MemoryMemberRepository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("hello");

        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외(){
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);
        assertThatThrownBy(() -> memberService.join(member2))
                .isInstanceOf(IllegalStateException.class);




//        try{
//            memberService.join(member2);
//            fail("예외가 발생해야 합니다.");
//        }catch (IllegalStateException e){
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }

        // then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }

    @Test
    void solution(){
       int[] sides = {1,3,3};
       int answer = 0;
       int sum = 0;
       int max = Arrays.stream(sides).max().getAsInt();
        System.out.println(IntStream.range(0, sides.length)
                .filter(i -> max == sides[i])
                .findFirst().getAsInt());
       sides [IntStream.range(0, sides.length)
                       .filter(i -> max == sides[i])
                               .findFirst().getAsInt()] = 0;

//       sides[Arrays.asList(sides).indexOf(max)]  = 0;

       for(int side : sides){
           if(side != max){
               sum += side;
           }
       }
        System.out.println(max);
        System.out.println(sum);
       if(max >= sum){
           answer = 2;
       }else{
           answer = 1;
       }

        System.out.println(answer);

    }
}