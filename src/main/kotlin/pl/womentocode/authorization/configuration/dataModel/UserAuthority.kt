package pl.womentocode.authorization.configuration.dataModel

import javax.persistence.*

@Entity
@Table(name="user_authority", uniqueConstraints = [UniqueConstraint(columnNames = ["user_id", "authority_id"], name="USER_AUTHORITY_UNIQUE_USER_ID_AND_AUTHORITY_ID")])
class UserAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", columnDefinition = "bigint unsigned")
    private var id: Int? = null

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "USER_ID", foreignKey = ForeignKey(name = "FK_USER_AUTHORITY_USER_ID"))
    private var user: User? = null

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "AUTHORITY_ID", foreignKey = ForeignKey(name = "FK_USER_AUTHORITY_AUTHORITY_ID"))
    private var authority: Authority? = null

    fun getId(): Int? {
        return id
    }

    fun setId(id: Int?) {
        this.id = id
    }

    fun getUser(): User? {
        return user
    }

    fun setUser(user: User) {
        this.user = user
    }

    fun getAuthority(): Authority? {
        return authority
    }

    fun setAuthority(authority: Authority) {
        this.authority = authority
    }
}