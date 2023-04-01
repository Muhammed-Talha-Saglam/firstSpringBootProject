package dev.bytecode.springboot.firstProject.firstProject.rest

import dev.bytecode.springboot.firstProject.firstProject.modal.Coach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

// @Autowired: Injects classes annotated with Components
// Use constructor injection when you have required dependencies.
@RestController
class FunRest @Autowired constructor(
    @Qualifier("cricketCoach") private val myCoach: Coach,
    @Qualifier("aquatic") private val swimCoach: Coach
) {

    private var baseballCoach: Coach? = null

    // Inject costum properties from application.properties
    @Value("\${team.name}")
    private lateinit var teamName: String

    // Use setter injection when you have optional dependencies.
    @Autowired
    fun doSomeStuffWithCoach( @Qualifier("baseballCoach") coach: Coach) {
        baseballCoach = coach
    }

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