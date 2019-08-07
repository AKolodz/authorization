package pl.womentocode.ticket.web.authorization

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter

//https://docs.spring.io/spring-security-oauth2-boot/docs/current/reference/html/boot-features-security-oauth2-resource-server.html
@EnableResourceServer
@Configuration
class Oauth2ResourceServerConfig : ResourceServerConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http.requestMatchers()
                .antMatchers("/greet/**")
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
    }
}