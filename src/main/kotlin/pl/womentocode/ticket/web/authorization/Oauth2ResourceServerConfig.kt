package pl.womentocode.ticket.web.authorization

import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter

@EnableResourceServer
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