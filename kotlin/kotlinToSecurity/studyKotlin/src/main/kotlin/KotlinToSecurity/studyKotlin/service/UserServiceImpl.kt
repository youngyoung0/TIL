package KotlinToSecurity.studyKotlin.service

import KotlinToSecurity.studyKotlin.repository.UserRepository
import KotlinToSecurity.studyKotlin.domain.UserDTO
import KotlinToSecurity.studyKotlin.domain.Users
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    val userRepository: UserRepository,
) : UserService {
    override fun getUser(userDTO: UserDTO): Users {
        return userRepository.save(
            Users(
                userId = userDTO.userId,
                pwd = userDTO.password,
                name = "",
                email = "",
            )
        )
    }
}