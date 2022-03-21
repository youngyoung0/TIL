package practice.jpa.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import org.springframework.stereotype.Repository
import practice.jpa.domain.Member
import practice.jpa.domain.QMember
import practice.jpa.domain.QMember.*
import practice.jpa.domain.QTeam
import practice.jpa.domain.SearchDTO
import javax.annotation.Resource


class MemberRepositoryImpl(
    @Resource(name = "jpaQueryFactory")
    val query : JPAQueryFactory
) : QuerydslRepositorySupport(Member::class.java) , MemberRepositoryCustom {

    override fun search(searchDTO: SearchDTO): MutableList<Member> {
        return query.select(member)
            .from(member)
            .innerJoin(QTeam.team).on(member.team.eq(QTeam.team))
            .fetch()
    }
}