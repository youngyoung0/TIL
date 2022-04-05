package com.querydsl.querydsl.domain

import com.querydsl.querydsl.domain.EntityAuditing
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "heelo")
data class Hello(
    @Column(name = "name", nullable = false)
    val name: String

) : EntityAuditing() {
}