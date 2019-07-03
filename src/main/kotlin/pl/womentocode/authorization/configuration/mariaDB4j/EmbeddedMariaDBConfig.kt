package pl.womentocode.authorization.configuration.mariaDB4j

import ch.vorburger.mariadb4j.springframework.MariaDB4jSpringService
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.core.env.Environment
import javax.sql.DataSource

@Configuration
//@Profile("local", "dev")
class EmbeddedMariaDBConfig {

    @Bean
    fun provideMariaDBSpringService(): MariaDB4jSpringService =
            MariaDB4jSpringService()

    @Bean
    fun provideDataSource(service: MariaDB4jSpringService, env: Environment): DataSource {

        service.db.createDB(env.getProperty("app.mariaDB4j.databaseName"))
        return DataSourceBuilder
                .create()
                .username("root")
                .password("")
                .url(service.configuration.getURL(env.getProperty("app.mariaDB4j.databaseName")))
                .driverClassName(env.getProperty("spring.datasource.driver-class-name"))
                .build()
    }

}