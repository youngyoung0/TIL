package practice.jpa;

import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import practice.jpa.domain.Member;
import practice.jpa.domain.QMember;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static practice.jpa.domain.QMember.member;

@SpringBootTest
public class QTypeTest {
    JPAQueryFactory queryFactory;

    @PersistenceContext
    EntityManager em;

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

    /**
     * 회원 정렬 순서
     * 1. 회원 나이 내림차순(desc)
     * 2. 회원 이름 오름차순(asc)
     * 단 2에서 회원 이름이 없으면 마지막에 출력 (nulls last)
     */
    @Test
    public void sort(){
        em.persist(new Member(null, 100));
        em.persist(new Member("member5", 100));
        em.persist(new Member("member6", 100));

        // 정렬
        // desc(), asc() 일반 정렬
        // nullsLast(), nullFirst() null 데이터 순서부여
        List<Member> result = queryFactory
                .selectFrom(member)
                .where(member.age.eq(100))
                .orderBy(member.age.desc(), member.username.asc().nullsLast())
                .fetch();

        Member member5 = result.get(0);
        Member member6 = result.get(1);
        Member memberNull = result.get(2);

        assertThat(member5.getUsername()).isEqualTo("member5");
        assertThat(member6.getUsername()).isEqualTo("member6");
        assertThat(memberNull.getUsername()).isNull();
    }
}