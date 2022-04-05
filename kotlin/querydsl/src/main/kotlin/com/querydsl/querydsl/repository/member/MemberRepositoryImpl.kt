//package com.querydsl.querydsl.repository.member
//
//import com.querydsl.querydsl.dto.MemberDtoQueryProjection
//
//import com.querydsl.core.BooleanBuilder
//import com.querydsl.jpa.impl.JPAQueryFactory
//import com.querydsl.querydsl.domain.Member
//import org.springframework.data.domain.Page
//import org.springframework.data.domain.Pageable
//import org.springframework.data.repository.support.PageableExecutionUtils
//
//class MemberRepositoryImpl(
//    private val query: JPAQueryFactory
//) : MemberRepositoryCustom {
//
//    override fun search(username: String?, age: Int?): Member {
//        return query
//            .selectFrom(qMember)
//            .where(searchCondition(username, age))
//            .fetchOne()!!
//
//    }
//
//    override fun search(username: String?, age: Int?, page: Pageable): Page<MemberDtoQueryProjection> {
//        val content = query
//            .select(QMemberDtoQueryProjection(
//                qMember.username,
//                qMember.age))
//            .from(qMember)
//            .where(searchCondition(username, age))
//            .offset(page.offset)
//            .limit(page.pageSize.toLong())
//            .orderBy()
//            .fetch()
//
//        val countQuery = query
//            .select(QMemberDtoQueryProjection(
//                qMember.username,
//                qMember.age))
//            .from(qMember)
//            .where(searchCondition(username, age))
//
//        return PageableExecutionUtils.getPage(content, page) { countQuery.fetchCount() }
//    }
//
//    private fun searchCondition(username: String?, age: Int?): BooleanBuilder {
//        val booleanBuilder = BooleanBuilder()
//
//        username.let {
//            booleanBuilder.and(qMember.username.eq(username))
//        }
//
//        age.let {
//            booleanBuilder.and(qMember.age.eq(age))
//        }
//
//        return booleanBuilder
//    }
//}
//
