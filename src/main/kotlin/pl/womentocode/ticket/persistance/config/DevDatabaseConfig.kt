package pl.womentocode.ticket.persistance.config

import ch.vorburger.mariadb4j.springframework.MariaDB4jSpringService
import com.mysql.cj.jdbc.Driver
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.DependsOn
import org.springframework.context.annotation.Profile
import org.springframework.jdbc.datasource.SimpleDriverDataSource


@Configuration
@Profile("dev")
class DevDatabaseConfig {

    private val DB_PORT = 3310

    @Bean(name = ["mariadb4j"])
    fun getMariaDB4j(): MariaDB4jSpringService =
            MariaDB4jSpringService()
                    .apply { this.setDefaultPort(DB_PORT) }


    @Bean
    @DependsOn("mariadb4j")
    fun getDataSource() =
            SimpleDriverDataSource()
                    .apply {
                        this.setDriverClass(Driver::class.java)
                        this.url = "jdbc:mysql://localhost:$DB_PORT/test?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC"
                        this.username = "root"
                    }
}