package KotlinToSecurity.studyKotlin.service

import KotlinToSecurity.studyKotlin.domain.UserDTO
import KotlinToSecurity.studyKotlin.domain.Users

interface UserService {
    fun getUser(userDTO: UserDTO): Users
}