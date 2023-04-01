package dev.bytecode.springboot.firstProject.firstProject.modal

class SwimCoach: Coach {
    override fun getDailyWorkout(): String {
        return "Swim 1000 miles"
    }
}