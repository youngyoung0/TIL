package practice.jpa.repository

import practice.jpa.domain.Member
import practice.jpa.domain.SearchDTO

interface MemberRepositoryCustom {
    fun search(searchDTO: SearchDTO) : MutableList<Member>
}