package practice.jpa;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import practice.jpa.domain.Member;
import practice.jpa.domain.QMember;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static practice.jpa.domain.QMember.member;

@SpringBootTest
public class QTypeTest {
    JPAQueryFactory queryFactory;

    @Test
    public void startQuerydsl(){
        QMember m = member;
        Member findMember=  queryFactory
                .select(m)
                .from(m)
                .where(m.username.eq("member1"))// 파라미터 바인딩 처리
                .fetchOne();

        assertThat(findMember.getUsername()).isEqualTo("member1");
    }

    @Test
    public void search(){
        Member findMember = queryFactory
                .selectFrom(member)
                .where(member.username.eq("member1")
                        .and(member.age.eq(10)))
                .fetchOne();

        assertThat(findMember.getUsername()).isEqualTo("member1");
        // member.userName.eq("member1")
        // member.userName.ne("member1")
        // member.username.eq("member1").not -> username != 'member1'
        // member.username.isNotnull() //이름이 is not null
        // member.age.in(10,20) age in (10,20)
        // member.age.notIn(10,20) age not in (10, 20)
        // member.age.between(10,30) // between 10, 30

        // member.age.goe(30) age>=30
        // member.age.get(30) age>30
        // member.age.loe(30 age<=30
        // member.age.lt(30) age<30

        // member.username.like("member%") like검색
        // member.username.contains("member") // like '%like%' 검색
        // member.username.startsWith("member") // like 'meber%'검색

    }

    @Test
    public void searchAndParam(){
        Member findMember = queryFactory
                .selectFrom(member)
                .where(
                        member.username.eq("member1"),
                        member.age.eq(10)
                        .and(member.age.eq(10)))
                .fetchOne();

}