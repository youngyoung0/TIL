package com.querydsl.querydsl.domain.item

import javax.persistence.Entity

@Entity
class Book {
    var author: String?=null
    var isbn: String?= null
}