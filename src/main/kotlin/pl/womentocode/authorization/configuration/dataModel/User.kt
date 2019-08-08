package pl.womentocode.authorization.configuration.dataModel

import java.util.HashSet
import javax.persistence.*

@Entity
@Table(name="user", uniqueConstraints = [UniqueConstraint(columnNames = ["userName"], name="USER_UNIQUE_USERNAME")])
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", columnDefinition = "bigint unsigned")
    private var id: Int? = null

    @Column(length = 50)
    private var userName: String? = null

    @Column
    private var password: String? = null

    @Column
    private var accountExpired: Boolean? = null

    @Column
    private var accountLocked: Boolean? = null

    @Column
    private var credentialsExpired: Boolean? = null

    @Column
    private var enabled: Boolean? = null

    @OneToMany(mappedBy = "user", targetEntity = UserAuthority::class, cascade = [CascadeType.ALL]
    , orphanRemoval = true, fetch = FetchType.EAGER)
    private var userAuthorities: Set<UserAuthority> = HashSet()

    fun getId(): Int? {
        return id
    }

    fun setId(id: Int?) {
        this.id = id
    }

    fun getUserName(): String? {
        return userName
    }

    fun setUserName(userName: String) {
        this.userName = userName
    }

    fun getPassword(): String? {
        return password
    }

    fun setPassword(password: String) {
        this.password = password
    }

    fun getAccountExpired(): Boolean? {
        return accountExpired
    }

    fun setAccountExpired(accountExpired: Boolean?) {
        this.accountExpired = accountExpired
    }

    fun getAccountLocked(): Boolean? {
        return accountLocked
    }

    fun setAccountLocked(accountLocked: Boolean?) {
        this.accountLocked = accountLocked
    }

    fun getCredentialsExpired(): Boolean? {
        return credentialsExpired
    }

    fun setCredentialsExpired(credentialsExpired: Boolean?) {
        this.credentialsExpired = credentialsExpired
    }

    fun getEnabled(): Boolean? {
        return enabled
    }

    fun setEnabled(enabled: Boolean?) {
        this.enabled = enabled
    }

    fun getUserAuthorities(): Set<UserAuthority> {
        return userAuthorities
    }

    fun setUserAuthorities(userAuthorities: Set<UserAuthority>) {
        this.userAuthorities = userAuthorities
    }
}