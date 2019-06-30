package pl.womentocode.ticket.web.authorization

import org.slf4j.LoggerFactory
import org.springframework.security.oauth2.common.OAuth2AccessToken
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore
import javax.sql.DataSource
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken

class CustomTokenStore(dataSource : DataSource) : JdbcTokenStore(dataSource) {
    private val logger = LoggerFactory.getLogger(CustomTokenStore::class.java)

    override fun readAccessToken(tokenValue: String?): OAuth2AccessToken? {
        var accessToken: OAuth2AccessToken? = null
        try {
            logger.info("read token $tokenValue")
            accessToken = DefaultOAuth2AccessToken(tokenValue)
        } catch (e: EmptyResultDataAccessException) {
            logger.info("Failed to find access token for token $tokenValue");
        } catch (e: IllegalArgumentException) {
            logger.warn("Failed to deserialize access token for $tokenValue",e);
            removeAccessToken(tokenValue)
        }
        logger.info("access token $accessToken")
        return accessToken
    }
}