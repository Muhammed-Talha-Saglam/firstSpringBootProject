package dev.bytecode.springboot.firstProject.firstProject

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.*


//@SpringBootApplication(
//		scanBasePackages = [
//			"dev.bytecode.springboot.firstProject.firstProject",
//			"dev.bytecode.springboot.firstProject.util",
//		]
//)
@SpringBootApplication
class FirstProjectApplication

fun main(args: Array<String>) {
	runApplication<FirstProjectApplication>(*args)
}

@Bean
fun commandLineRunner(args: Array<String>) : CommandLineRunner {
	return  CommandLineRunner {
		println("Hello commandLineRunner")
	}
}
