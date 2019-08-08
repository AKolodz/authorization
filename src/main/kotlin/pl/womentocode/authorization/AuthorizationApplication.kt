package pl.womentocode.authorization

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories


@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
@EntityScan("pl.womentocode")
@EnableJpaRepositories("pl.womentocode")
@ComponentScan("pl.womentocode")
class AuthorizationApplication

fun main(args: Array<String>) {
    runApplication<AuthorizationApplication>(*args)
}
