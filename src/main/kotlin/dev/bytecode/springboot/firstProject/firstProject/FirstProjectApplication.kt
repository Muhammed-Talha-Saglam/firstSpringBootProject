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
//		createStudent(studentDao)
//		createMultipleStudent(studentDao)
//		readStudent(studentDao)
//		queryForStudents(studentDao)
//		queryByLastName(studentDao)
//		updateStudent(studentDao)
//		deleteStudent(studentDao)
//		deleteAllStudents(studentDao)


	}

}

fun deleteAllStudents(studentDao: StudentDao) {
	val numsDeleted = studentDao.deleteAll()
	println("numsDeleted: $numsDeleted")
}

fun deleteStudent(studentDao: StudentDao) {
	studentDao.delete(13)
}

fun updateStudent(studentDao: StudentDao) {
	val id = 1
	val student = studentDao.findById(1)
	println("Updating student: $student")

	student?.let {
		student.firstName = "Freddy"
		studentDao.update(student)

	}

}

fun queryByLastName(studentDao: StudentDao) {
	val students = studentDao.findByLastName("Saglam")
	println(students)
}

fun queryForStudents(studentDao: StudentDao) {
	val result = studentDao.findAll()
	println(result)
}

fun readStudent(studentDao: StudentDao) {
	val tempStudent = Student(firstName = "Talha", lastName = "Saglam", email = "talha@saglam.com")

	studentDao.save(tempStudent)

	val student = studentDao.findById(tempStudent.id!!)
	println("student by id ${tempStudent.id}: $student")


}

fun createMultipleStudent(studentDao: StudentDao) {
	println("Hello from createStudent")

	val tempStudent2 = Student(firstName = "John", lastName = "Lennon", email = "john@lennon.com")
	val tempStudent3 = Student(firstName = "Sam", lastName = "Kim", email = "sam@kim.com")
	val tempStudent4 = Student(firstName = "Harry", lastName = "Potter", email = "harry@potter.com")

	studentDao.save(tempStudent2)
	studentDao.save(tempStudent3)
	studentDao.save(tempStudent4)

}

fun createStudent(studentDao: StudentDao) {
	println("Hello from createStudent")

	val tempStudent = Student(firstName = "Freddy", lastName = "Mercury", email = "freddy@quens.com")
	println("tempStudent: $tempStudent")
	println(tempStudent)

	studentDao.save(tempStudent)

	println("saved studentId: ${tempStudent.id}")

}