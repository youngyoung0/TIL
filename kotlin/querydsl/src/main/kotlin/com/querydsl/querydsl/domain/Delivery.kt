package com.querydsl.querydsl.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import lombok.Getter
import lombok.Setter
import javax.persistence.*

@Entity
@Getter
@Setter
@Table(name="delivery")
class Delivery {
    @Id @GeneratedValue
    @Column(name="delivery_id")
    var id : Long = 0;

    @JsonIgnore
    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    lateinit var order: Order

    @Embedded
    lateinit var address: Address ;

    @Enumerated(EnumType.STRING)
    lateinit var  status:DeliverStatus
// READY, COMP
}