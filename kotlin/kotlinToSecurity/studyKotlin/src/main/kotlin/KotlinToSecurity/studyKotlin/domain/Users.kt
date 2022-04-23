package KotlinToSecurity.studyKotlin.domain

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Users (
    var userId: String,
    var name : String,
    var email: String,
    var pwd: String,
): UserDetails {
    @Id
    @GeneratedValue
    var id:Long ?= null

    val role = ROLE_TYPE.MEMBER

    override fun getPassword(): String = pwd!!

    override fun getUsername(): String = name!!

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = true

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        val authorities = mutableListOf<GrantedAuthority>()

        when(role){
            ROLE_TYPE.ADMIN -> authorities.add(SimpleGrantedAuthority("ROLE_ADMIN"))
            ROLE_TYPE.MEMBER -> authorities.add(SimpleGrantedAuthority("ROLE_MEMBER"))
        }
        return authorities
    }


}