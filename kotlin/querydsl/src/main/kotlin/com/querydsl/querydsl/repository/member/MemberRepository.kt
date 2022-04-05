package com.querydsl.querydsl.repository.member


import com.querydsl.querydsl.domain.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<Member, Long>, MemberRepositoryCustom