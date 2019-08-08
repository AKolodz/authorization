package pl.womentocode.authorization.configuration

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import pl.womentocode.authorization.configuration.dataModel.User

interface UserDao : JpaRepository<User, Int> {

    @Query("SELECT DISTINCT u FROM User u WHERE u.userName = :username")
    fun findByUsername(@Param("username") username: String): User
}