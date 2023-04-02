package dev.bytecode.springboot.firstProject.firstProject.rest

import dev.bytecode.springboot.firstProject.firstProject.entity.Student
import dev.bytecode.springboot.firstProject.firstProject.modal.Coach
import dev.bytecode.springboot.firstProject.firstProject.modal.StudentErrorResponse
import dev.bytecode.springboot.firstProject.firstProject.modal.StudentNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.Exception

// @Autowired: Injects classes annotated with Components
// Use constructor injection when you have required dependencies.
@RestController
@RequestMapping("/api")
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

    @GetMapping("/students/{studentId}")
    fun studentById(@PathVariable studentId: Int):  Student? {

        val students = mutableListOf<Student>()
        students.add(Student(firstName = "asf", lastName = "afgg", email = "mail"))
        students.add(Student(firstName = "asf", lastName = "afgg", email = "mail"))
        students.add(Student(firstName = "asf", lastName = "afgg", email = "mail"))

        if (studentId >= students.size || studentId < 0) {
            throw StudentNotFoundException("Student Id not found - $studentId")
        }

        // Students list is converted to JSON automatically.
        return students[studentId]
    }


    @GetMapping("/students")
    fun students(): List<Student> {
        val students = mutableListOf<Student>()
        students.add(Student(firstName = "asf", lastName = "afgg", email = "mail"))
        students.add(Student(firstName = "asf", lastName = "afgg", email = "mail"))
        students.add(Student(firstName = "asf", lastName = "afgg", email = "mail"))

        // Students list is converted to JSON automatically.
        return students
    }

    @GetMapping("/workout")
    fun dailyWorkout(): String {
        return swimCoach.getDailyWorkout()
    }

    @GetMapping("/fortune")
    fun dailyFortune(): String {
        return "Today is your lucky day."
    }

//    @ExceptionHandler
//    fun handleException(studentNotFoundException: StudentNotFoundException): ResponseEntity<StudentErrorResponse> {
//        val error = StudentErrorResponse(HttpStatus.NOT_FOUND.value(), studentNotFoundException.message, System.currentTimeMillis())
//        return ResponseEntity(error, HttpStatus.NOT_FOUND)
//    }
//
//    @ExceptionHandler
//    fun handleException(exception: Exception) : ResponseEntity<StudentErrorResponse> {
//        val error = StudentErrorResponse(HttpStatus.BAD_REQUEST.value(), exception.message, System.currentTimeMillis())
//        return ResponseEntity(error, HttpStatus.BAD_REQUEST)
//    }
}