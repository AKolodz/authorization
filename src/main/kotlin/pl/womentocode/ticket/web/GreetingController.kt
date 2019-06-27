package pl.womentocode.ticket.web

import org.springframework.context.annotation.Profile
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/greet")
class GreetingController {

    @RequestMapping("","/{person}")
    fun greetPerson(@PathVariable(name = "person", required = false) person : String?)=
            "Hello ${person?:"PlayerUnknown"}"
}

@Profile("dev")
@RestController
@RequestMapping("/greet/dev")
class GreetingDevController {

    @RequestMapping("","/{person}")
    fun greetPerson(@PathVariable(name = "person", required = false) person : String?)=
            "Hello in DEV server, ${person?:"PlayerUnknown"}"
}