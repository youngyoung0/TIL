package practice.jpa;

import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import practice.jpa.domain.Member;
import practice.jpa.domain.QMember;

import java.util.List;

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
    public void searchAndParam() {
        Member findMember = queryFactory
                .selectFrom(member)
                .where(
                        member.username.eq("member1"),
                        member.age.eq(10)
                                .and(member.age.eq(10)))
                .fetchOne();
    }

    @Test
    public void resultFetch(){
        // 리스트 조회, 데이터 없으면 빈 리스트 반환
        List<Member> fetch = queryFactory
                .selectFrom(member)
                .fetch();

        // 단 건 조회
        // 결과 없으면 null, 결과가 둘 이상이면 com.querydsl.core.NonUniqueResultException
        Member fetchOne = queryFactory
                .selectFrom(QMember.member)
                .fetchOne();

        //
        Member fetchFirst =  queryFactory
                .selectFrom(member)
                .fetchFirst();

        // 페이징 정보 포함, totalcount 쿼리 추가 실행
        QueryResults<Member> results = queryFactory
                .selectFrom(member)
                .fetchResults();

        
        results.getTotal();
        List<Member> content = results.getResults();

        // count 쿼리로 변경시 count수 조회
        long total = queryFactory
                .selectFrom(member)
                .fetchCount();
    }
}