package dev.bytecode.springboot.firstProject.firstProject.modal

import jakarta.annotation.PostConstruct
import jakarta.annotation.PreDestroy
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Primary
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Primary
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON) // Default scope is SCOPE_SINGLETON
class CricketCoach: Coach {

    override fun getDailyWorkout(): String {
        return "Practice fast bowling for 15 minutes."
    }

    @PostConstruct
    fun doStartupStuff() {
    }

    @PreDestroy
    fun doCleanUpStuff(){

    }
}