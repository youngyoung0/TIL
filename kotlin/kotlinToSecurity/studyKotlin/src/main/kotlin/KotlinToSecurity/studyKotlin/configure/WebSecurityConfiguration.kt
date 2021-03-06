package KotlinToSecurity.studyKotlin.configure

import KotlinToSecurity.studyKotlin.service.UserCustomService
import org.springframework.beans.factory.annotation.Configurable
import org.springframework.context.annotation.Bean
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@Configurable
@EnableWebSecurity
class WebSecurityConfiguration(
    val userCustomService: UserCustomService
): WebSecurityConfigurerAdapter() {

    @Bean
    fun encoder(): PasswordEncoder = BCryptPasswordEncoder(11)

    override fun configure(auth: AuthenticationManagerBuilder?){
        auth?.authenticationProvider(authenticationProvider())
    }

    @Bean
    fun authenticationProvider(): DaoAuthenticationProvider{
        val authProvider = DaoAuthenticationProvider()
        authProvider.setUserDetailsService(userCustomService)
        authProvider.setPasswordEncoder(encoder())
        return authProvider
    }

    override fun configure(http: HttpSecurity?) {
        http
            ?.csrf()?.disable()
            ?.authorizeRequests()
            ?.antMatchers("/resources/**")?.permitAll()
            ?.anyRequest()?.permitAll()
            ?.and()
            ?.formLogin()
            ?.loginPage("/login")
            ?.loginProcessingUrl("/login")
            ?.defaultSuccessUrl("/home")
            ?.and()
            ?.logout()
            ?.logoutUrl("/logout")
    }

}