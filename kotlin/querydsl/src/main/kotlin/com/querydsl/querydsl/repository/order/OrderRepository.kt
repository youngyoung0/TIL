package com.querydsl.querydsl.repository.order


import com.querydsl.querydsl.domain.Order
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository : JpaRepository<Order, Long>