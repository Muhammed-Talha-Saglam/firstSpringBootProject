package dev.bytecode.springboot.firstProject.firstProject.config

import dev.bytecode.springboot.firstProject.firstProject.modal.Coach
import dev.bytecode.springboot.firstProject.firstProject.modal.SwimCoach
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SportConfig {

    // The bean defaults to the method name.
    @Bean("aquatic")
    fun swimCoach() : Coach {
        return SwimCoach()
    }
}