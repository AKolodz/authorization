package pl.womentocode.ticket

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationManager
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices

@Configuration
@EnableResourceServer
class ResourceServerConfiguration : ResourceServerConfigurerAdapter() {
    override fun configure(resources: ResourceServerSecurityConfigurer?) {
        resources!!
                .resourceId("resource-server-rest-api")
                .authenticationManager(authenticationManagerBean())
    }

    override fun configure(http: HttpSecurity?) {
        super.configure(http)
    }

    @Bean
    fun authenticationManagerBean(): AuthenticationManager {
        val authenticationManager = OAuth2AuthenticationManager()
        authenticationManager.setTokenServices(tokenService())
        return authenticationManager
    }

    @Bean
    fun tokenService(): ResourceServerTokenServices {
        return CustomRemoteTokenService()
    }
}
