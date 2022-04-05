package com.querydsl.querydsl.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import lombok.Getter
import lombok.Setter
import javax.persistence.*

@Entity
@Getter
@Setter
@Table(name = "members")
data class Member (
    @Id
    @GeneratedValue
    @Column(name = "id")
    var id: Long ?=null,

    @Column
    var name: String?=null,

    @Embedded
    var address  : Address?=null,

    @JsonIgnore
    @OneToMany(mappedBy = "member")
    var orders: List<Order> ?= null,
){

}