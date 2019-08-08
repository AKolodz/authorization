package pl.womentocode.authorization.configuration

import org.springframework.security.core.userdetails.UsernameNotFoundException
import pl.womentocode.authorization.configuration.dataModel.UserAuthority
import org.springframework.security.core.GrantedAuthority
import java.util.HashSet
import org.apache.tomcat.jni.SSL.setPassword
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import pl.womentocode.authorization.configuration.dataModel.dto.CustomGrantedAuthority
import pl.womentocode.authorization.configuration.dataModel.dto.CustomUserDetails
import javax.transaction.Transactional


@Service
@Transactional
class UserDetailsServiceImpl : UserDetailsService {

    @Autowired
    private val userDao: UserDao? = null

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        val user = userDao!!.findByUsername(username)
        val customUserDetails = CustomUserDetails()
        customUserDetails.setUserName(user!!.getUserName()!!)
        customUserDetails.setPassword(user!!.getPassword()!!)
        val authorities = HashSet<GrantedAuthority>()
        for (authority in user!!.getUserAuthorities()) {
            authorities.add(CustomGrantedAuthority(authority.getAuthority()!!.getName()!!))
        }
        customUserDetails.setGrantedAuthorities(authorities)
        return customUserDetails
        throw UsernameNotFoundException(username)
    }
}