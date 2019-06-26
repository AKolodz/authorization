package pl.womentocode.ticket

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableAutoConfiguration(exclude = [SecurityAutoConfiguration::class])
class TicketApplication

fun main(args: Array<String>) {
	runApplication<TicketApplication>(*args)
}
