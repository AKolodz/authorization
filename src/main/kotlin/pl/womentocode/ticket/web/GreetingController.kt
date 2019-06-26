package pl.womentocode.ticket.web

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