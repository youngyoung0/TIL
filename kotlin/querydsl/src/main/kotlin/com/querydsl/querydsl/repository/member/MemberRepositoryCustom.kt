package com.querydsl.querydsl.repository.member


import com.querydsl.querydsl.dto.MemberDtoQueryProjection
import com.querydsl.querydsl.domain.Member
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface MemberRepositoryCustom {

    fun search(username: String?, age: Int?): Member
    fun search(username: String?, age: Int?, page: Pageable): Page<MemberDtoQueryProjection>

}