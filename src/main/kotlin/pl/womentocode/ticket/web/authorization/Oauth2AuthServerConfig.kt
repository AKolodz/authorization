package pl.womentocode.ticket.web.authorization

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer
import org.springframework.security.oauth2.provider.token.TokenStore
import org.springframework.security.authentication.AuthenticationManager

@Configuration
@EnableAuthorizationServer
class Oauth2AuthServerConfig : AuthorizationServerConfigurerAdapter() {

    @Autowired
    private lateinit var tokenStore: TokenStore
    @Autowired
    lateinit var authenticationManager: AuthenticationManager

//    override fun configure(authConfigurer: AuthorizationServerSecurityConfigurer) {
//        authConfigurer
//                .tokenKeyAccess("permitAll()")
//                .checkTokenAccess("isAuthenticated()")
//    }

//    override fun configure(clients: ClientDetailsServiceConfigurer) {
//        clients.inMemory()
//                .withClient("frontendClientId")
//                .secret("{noop}frontendClientSecret")
//                .authorizedGrantTypes(
//                        "password",
//                        "authorization_code",
//                        "refresh_token")
//                .refreshTokenValiditySeconds(24 * 60 * 60 * 28)
//                .accessTokenValiditySeconds(3600)
//                .scopes("read")
//    }

    override fun configure(endpoints: AuthorizationServerEndpointsConfigurer) {
        endpoints
                .tokenStore(tokenStore)
                .authenticationManager(authenticationManager)
    }
}