package practice.jpa.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import practice.jpa.domain.Team

@Repository
interface TeamRepository : JpaRepository<Team, Long> {
}