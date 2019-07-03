package pl.womentocode.authorization

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.core.env.Environment
import org.springframework.core.env.get
import pl.womentocode.authorization.configuration.mariaDB4j.EmbeddedMariaDBConfig

@SpringBootApplication
class AuthorizationApplication

fun main(args: Array<String>) {
    var context = runApplication<AuthorizationApplication>(*args)
//    var env = context.getBean(Environment::class.java)
//    print(env.getProperty("server.port"))

}
