package com.querydsl.querydsl.domain

import javax.persistence.Embeddable


@Embeddable
class Address {
    private var city: String? = null
    private var street: String? = null
    private var zipcode: String? = null

    protected constructor() {}
    constructor(city: String?, street: String?, zipcode: String?) {
        this.city = city
        this.street = street
        this.zipcode = zipcode
    }
}