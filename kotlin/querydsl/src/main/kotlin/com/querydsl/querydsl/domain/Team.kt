package com.querydsl.querydsl.domain

import com.querydsl.querydsl.domain.EntityAuditing
import com.querydsl.querydsl.domain.Member
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "team")
data class Team(
    @Column(name = "name", nullable = false)
    var name: String
) : EntityAuditing() {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "team")
    var members: MutableList<Member> = mutableListOf()
}