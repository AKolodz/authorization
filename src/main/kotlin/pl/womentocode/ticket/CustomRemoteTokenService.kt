package pl.womentocode.ticket

import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.security.oauth2.common.OAuth2AccessToken
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException
import org.springframework.security.oauth2.provider.OAuth2Authentication
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices
import org.springframework.util.MultiValueMap
import org.springframework.web.client.RestTemplate


class CustomRemoteTokenService : ResourceServerTokenServices {

    private val restTemplate = RestTemplate()
    private val tokenConverter = DefaultAccessTokenConverter()

    override fun loadAuthentication(accessToken: String): OAuth2Authentication {
        val headers = HttpHeaders()
        val map = executeGet("http://localhost:8095/oauth/check_token?token=$accessToken", headers)
        if (map.isEmpty() || map["error"] != null) {
            throw InvalidTokenException("Token not allowed")
        }
        return tokenConverter.extractAuthentication(map)
    }

    override fun readAccessToken(p0: String): OAuth2AccessToken {
        throw UnsupportedOperationException("Not supported: READ accessToken")
    }

    private fun executeGet(path: String, headers: HttpHeaders): Map<String, *> {
            headers.contentType = MediaType.APPLICATION_FORM_URLENCODED
        val map : Map<*, *>? = restTemplate.exchange(path, HttpMethod.GET, HttpEntity<MultiValueMap<String, String>>(null, headers), Map::class.java).body
        val result = map as Map<String, *>
        return result!!

    }
}