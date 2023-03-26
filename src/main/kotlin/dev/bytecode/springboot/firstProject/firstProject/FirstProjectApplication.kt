package dev.bytecode.springboot.firstProject.firstProject

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication(
		scanBasePackages = [
			"dev.bytecode.springboot.firstProject.firstProject",
			"dev.bytecode.springboot.firstProject.util",
		]
)
class FirstProjectApplication

fun main(args: Array<String>) {
	runApplication<FirstProjectApplication>(*args)
}