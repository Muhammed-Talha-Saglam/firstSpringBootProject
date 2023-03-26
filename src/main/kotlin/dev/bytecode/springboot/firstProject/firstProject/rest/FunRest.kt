package dev.bytecode.springboot.firstProject.firstProject.rest

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class FunRest {

    @Value("\${team.name}")
    private lateinit var teamName: String

    @GetMapping("/")
    fun home(): String {
        return "Spring is coming by $teamName"
    }

    @GetMapping("/workout")
    fun dailyWorkout(): String {
        return "Run a hard 5k!"
    }

    @GetMapping("/fortune")
    fun dailyFortune(): String {
        return "Today is your lucky day."
    }
}