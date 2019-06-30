package pl.womentocode.ticket.web

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore
import javax.sql.DataSource

@Configuration
@EnableWebSecurity
class CustomWebSecurityConfigurer : WebSecurityConfigurerAdapter(){

    @Autowired
    private lateinit var dataSource : DataSource

    override fun configure(auth: AuthenticationManagerBuilder) {
        val userDataQueryPattern = "SELECT email,password_hash,active FROM users WHERE email=?"
        val authoritiesQueryPattern = "SELECT ' ','ADMIN' FROM users WHERE email=?" //should be *->ADMIN probably but SQL exception
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(userDataQueryPattern)
                .authoritiesByUsernameQuery(authoritiesQueryPattern)
                .passwordEncoder(getPasswordEncoder())
    }

    private fun getPasswordEncoder(): PasswordEncoder =
            BCryptPasswordEncoder()

    //     override fun configure(http: HttpSecurity) {
//        http.csrf().disable().authorizeRequests().anyRequest().permitAll()
//    }
    @Bean
    override fun authenticationManagerBean(): AuthenticationManager {
        return super.authenticationManagerBean()
    }
}