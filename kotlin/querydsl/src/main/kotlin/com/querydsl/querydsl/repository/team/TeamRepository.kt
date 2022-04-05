package com.example.querydsl.repository.team

import com.querydsl.querydsl.domain.Team
import org.springframework.data.jpa.repository.JpaRepository

interface TeamRepository : JpaRepository<Team, Long> {
}