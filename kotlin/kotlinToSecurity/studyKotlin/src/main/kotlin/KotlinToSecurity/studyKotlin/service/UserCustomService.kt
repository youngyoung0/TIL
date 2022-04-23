package KotlinToSecurity.studyKotlin.service

import KotlinToSecurity.studyKotlin.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserCustomService(
    val userRepository: UserRepository
): UserDetailsService{

    override fun loadUserByUsername(username: String?): UserDetails? {
        return userRepository.findByName(username!!)
    }

}