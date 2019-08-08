package pl.womentocode.authorization.configuration.dataModel.dto

import org.springframework.security.core.GrantedAuthority
import java.io.Serializable

class CustomGrantedAuthority(val name: String) : Serializable, GrantedAuthority{

    override fun getAuthority(): String {
        return name
    }
}