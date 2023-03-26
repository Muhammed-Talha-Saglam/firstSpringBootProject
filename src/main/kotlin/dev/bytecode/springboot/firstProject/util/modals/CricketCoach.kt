package dev.bytecode.springboot.firstProject.util.modals

import org.springframework.stereotype.Component

@Component
class CricketCoach: Coach {

    override fun getDailyWorkout(): String {
        return "Practice fast bowling for 15 minutes."
    }
}