package pl.womentocode.ticket

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration
import org.springframework.security.oauth2.provider.expression.OAuth2MethodSecurityExpressionHandler
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler



@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
class Oauth2GlobalMethodConfig : GlobalMethodSecurityConfiguration(){

    override fun createExpressionHandler(): MethodSecurityExpressionHandler {
        return OAuth2MethodSecurityExpressionHandler()
    }
}