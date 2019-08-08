package pl.womentocode.authorization.configuration.dataModel.dto

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails


class CustomUserDetails : UserDetails{


    private var userName: String? = null

    private var password: String? = null

    private var grantedAuthorities: Set<GrantedAuthority>? = null


    override fun getAuthorities(): Collection<GrantedAuthority>? {
        return grantedAuthorities
    }

    override fun getPassword(): String? {
        return password
    }

    override fun getUsername(): String? {
        return userName
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }

    fun setUserName(userName: String) {
        this.userName = userName
    }

    fun getGrantedAuthorities(): Set<GrantedAuthority>? {
        return grantedAuthorities
    }

    fun setGrantedAuthorities(grantedAuthorities: Set<GrantedAuthority>) {
        this.grantedAuthorities = grantedAuthorities
    }

    fun setPassword(password: String) {
        this.password = password
    }
}