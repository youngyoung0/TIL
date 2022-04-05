package com.querydsl.querydsl.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import com.querydsl.querydsl.domain.item.Item
import javax.persistence.*

@Entity
class OrderItem {
    @Id @GeneratedValue
    @Column(name = "order_item_id")
    var id:Long?=null

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="item_id")
    var item: Item?=null;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="order_id")
    var order: Order ?=null

    var orderPrice:Int?=null // 주문가격
    var count:Int?=null // 주문수량
}