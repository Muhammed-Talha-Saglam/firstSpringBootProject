package dev.bytecode.springboot.firstProject.firstProject

import dev.bytecode.springboot.firstProject.firstProject.dao.StudentDao
import dev.bytecode.springboot.firstProject.firstProject.entity.Student
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
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
	println("Hello from main function")
	runApplication<FirstProjectApplication>(*args)
}


@Component
class FirstRunner(val studentDao: StudentDao) : CommandLineRunner {
	override fun run(vararg args: String?) {
		println("Hello from FirstRunner")
		createStudent(studentDao)

	}

}

fun createStudent(studentDao: StudentDao) {
	println("Hello from createStudent")

	val tempStudent = Student(firstName = "Freddy", lastName = "Mercury", email = "freddy@quens.com")
	println("tempStudent: $tempStudent")
	println(tempStudent)

	studentDao.save(tempStudent)

	println("saved studentId: ${tempStudent.id}")

}