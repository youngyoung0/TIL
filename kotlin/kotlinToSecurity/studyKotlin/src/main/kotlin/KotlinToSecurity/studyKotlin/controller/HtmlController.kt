package KotlinToSecurity.studyKotlin.controller

import KotlinToSecurity.studyKotlin.domain.UserDTO
import KotlinToSecurity.studyKotlin.service.UserService
import KotlinToSecurity.studyKotlin.domain.Users
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/")
class HtmlController(
    val userService: UserService,
) {
    @GetMapping
    fun index():String ="index"

    @GetMapping("form")
    fun getUser( @ModelAttribute userDTO: UserDTO): Users {
        return userService.getUser(userDTO)
    }
}