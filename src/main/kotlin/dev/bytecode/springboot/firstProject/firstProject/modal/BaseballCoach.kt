package dev.bytecode.springboot.firstProject.firstProject.modal

import jakarta.annotation.PostConstruct
import jakarta.annotation.PreDestroy
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Lazy
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
// A new instance is created for each container request. Prototypes are also lazy by default
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class BaseballCoach: Coach {

    override fun getDailyWorkout(): String {
        return "Baseball coach daily"
     }

 }
