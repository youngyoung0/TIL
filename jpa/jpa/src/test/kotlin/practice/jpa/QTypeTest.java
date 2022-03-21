package practice.jpa;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import practice.jpa.domain.Member;
import practice.jpa.domain.QMember;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class QTypeTest {
    JPAQueryFactory queryFactory;

    @Test
    public void startQuerydsl(){
        QMember m = QMember.member;
        Member findMember=  queryFactory
                .select(m)
                .from(m)
                .where(m.username.eq("member1"))// 파라미터 바인딩 처리
                .fetchOne();

        assertThat(findMember.getUsername()).isEqualTo("member1");
    }
    
}
