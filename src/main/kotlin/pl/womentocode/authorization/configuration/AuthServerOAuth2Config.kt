package pl.womentocode.authorization.configuration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer
import org.springframework.security.oauth2.provider.token.TokenStore
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore
import javax.sql.DataSource


@EnableAuthorizationServer
@Configuration
class AuthServerOAuth2Config : AuthorizationServerConfigurerAdapter() {

    @Autowired
    private lateinit var tokenStore: TokenStore
    @Autowired lateinit var authenticationManager : AuthenticationManager

    override fun configure(security: AuthorizationServerSecurityConfigurer) {
        security.tokenKeyAccess("permitAll()")
                .checkTokenAccess("permitAll()")
    }

    override fun configure(clients: ClientDetailsServiceConfigurer) {
        clients.inMemory()
                .withClient("clientId")
                .secret("{noop}secret")
                .authorizedGrantTypes(
                        "password",
                        "authorization_code",
                        "refresh_token",
                        "client_credentials")
                .refreshTokenValiditySeconds(24 * 60 * 60 * 28)
                .accessTokenValiditySeconds(3600)
                .scopes("read")
    }

    override fun configure(endpoints: AuthorizationServerEndpointsConfigurer) {
        super.configure(endpoints)
        endpoints
                .authenticationManager(authenticationManager) //to allow password token
                .tokenStore(tokenStore)
    }

    @Bean
    fun provideTokenStore(dataSource: DataSource): TokenStore =
            JdbcTokenStore(dataSource)
}