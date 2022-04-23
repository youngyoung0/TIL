package KotlinToSecurity.studyKotlin.repository

import KotlinToSecurity.studyKotlin.domain.Users
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<Users,Long>{
    fun findByName(name: String): Users?
}