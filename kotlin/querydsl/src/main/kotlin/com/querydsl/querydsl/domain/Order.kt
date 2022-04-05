package com.querydsl.querydsl.domain

import lombok.Getter
import lombok.Setter
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Getter
@Setter
@Table(name="orders")
class Order (){
    @Id @GeneratedValue
    @Column(name="order_id")
    var id: Long?=null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    var member: Member?=null

    @OneToMany(mappedBy = "order")
    var orderItems: List<OrderItem>  ?=null

    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    var delivery:Delivery?=null // 배송정보

    var orderDate: LocalDateTime?=null // 주문시간

    @Enumerated(EnumType.STRING)
    lateinit var status: OrderStatus; // 주문상태 [ORDER , CANCEL]
}

