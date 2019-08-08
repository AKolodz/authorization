package pl.womentocode.authorization.configuration.dataModel

import javax.persistence.*

@Entity
@Table(name="authority", uniqueConstraints = [UniqueConstraint(columnNames = ["name"], name="AUTHORITY_UNIQUE_NAME")])
class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", columnDefinition = "bigint unsigned")
    private var id: Int? = null

    @Column(length = 20)
    private var name: String? = null

    fun getId(): Int? {
        return id
    }

    fun setId(id: Int?) {
        this.id = id
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

}