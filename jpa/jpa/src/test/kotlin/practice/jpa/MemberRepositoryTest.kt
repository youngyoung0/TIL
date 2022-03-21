package practice.jpa

import com.querydsl.core.BooleanBuilder
import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.jpa.impl.JPAQueryFactory
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import practice.jpa.domain.Member
import practice.jpa.domain.QMember
import practice.jpa.domain.QTeam
import practice.jpa.domain.SearchDTO
import practice.jpa.repository.MemberRepository
import practice.jpa.repository.TeamRepository
import java.util.Optional
import java.util.stream.IntStream

@SpringBootTest
class MemberRepositoryTest(
    @Autowired
    val memberRepository: MemberRepository,

    @Autowired
    val teamRepository: TeamRepository,

    @Autowired
    val query : JPAQueryFactory
) {

    @Test
    fun insertTest(){

        IntStream.rangeClosed(1, 300).forEach {
            var member : Member = Member()
            member.name = "user $it"

            if (it < 100){
                member.team = teamRepository.findById(1L).get()
            }else if (it < 200){
                member.team = teamRepository.findById(2L).get()
            }else{
                member.team = teamRepository.findById(3L).get()
            }

            memberRepository.save(member)
        }
    }

    @Test
    fun pagingTest(){
        val page : Pageable = PageRequest.of(5, 50)
        val pagingMember = memberRepository.pagingMember(page)

        val toList : MutableList<Member> = pagingMember.toList()

        println(pagingMember.toString())

        toList.stream().forEach { it ->
            println(it.id)
            println(it.name)
        }

    }

    @Test
    fun updateTest(){
        IntStream.rangeClosed(1, 300).forEach {
            val findMember = memberRepository.findById(it.toLong())
            val member = findMember.get()
            member.gender = "남자"
            member.ban = it
            memberRepository.save(member)
        }
    }

    @Test
    fun testQuery() {
        var qMember : QMember = QMember.member

        var keyword : String = "남자"

        var builder : BooleanBuilder = BooleanBuilder()

        var expression : BooleanExpression = qMember.gender.matches(keyword)

        builder.and(expression)

        val findAll  = memberRepository.findAll(builder)

        findAll.forEach {
            println(it)
        }
    }

    @Test
    fun testJoin() {
        val fetch = query.select(QMember.member)
            .from(QMember.member)
            .innerJoin(QTeam.team).on(QMember.member.team.eq(QTeam.team))
            .where(QMember.member.team.id.eq(2))
            .fetch()

        fetch.stream().forEach {
            println(it.name)
        }


        println("-----------------------------------")
        val search = memberRepository.search(SearchDTO().apply {
            this.ban = 3
        })

        search.stream().forEach {
            println(it.name)
        }
    }
}