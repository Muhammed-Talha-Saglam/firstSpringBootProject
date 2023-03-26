package dev.bytecode.springboot.firstProject.firstProject.rest

import dev.bytecode.springboot.firstProject.util.modals.Coach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class FunRest @Autowired constructor(private val myCoach: Coach) {

    @Value("\${team.name}")
    private lateinit var teamName: String

    @GetMapping("/")
    fun home(): String {
        return "Spring is coming by $teamName"
    }

    @GetMapping("/workout")
    fun dailyWorkout(): String {
        return myCoach.getDailyWorkout()
    }

    @GetMapping("/fortune")
    fun dailyFortune(): String {
        return "Today is your lucky day."
    }
}