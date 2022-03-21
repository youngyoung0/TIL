package practice.jpa.repository

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import practice.jpa.domain.Member

interface MemberRepository : JpaRepository<Member, Long>, QuerydslPredicateExecutor<Member> {

    @Query("select m from Member m order by m.id desc ")
    fun pagingMember(pageable: Pageable) : Page<Member>



}