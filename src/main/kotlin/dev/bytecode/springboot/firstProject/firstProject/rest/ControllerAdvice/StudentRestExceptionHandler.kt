package dev.bytecode.springboot.firstProject.firstProject.rest.ControllerAdvice

import dev.bytecode.springboot.firstProject.firstProject.modal.StudentErrorResponse
import dev.bytecode.springboot.firstProject.firstProject.modal.StudentNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.lang.Exception

@ControllerAdvice
class StudentRestExceptionHandler {

    @ExceptionHandler
    fun handleException(studentNotFoundException: StudentNotFoundException): ResponseEntity<StudentErrorResponse> {
        val error = StudentErrorResponse(HttpStatus.NOT_FOUND.value(), studentNotFoundException.message, System.currentTimeMillis())
        return ResponseEntity(error, HttpStatus.NOT_FOUND)
    }

    // Generic exception handler.
    @ExceptionHandler
    fun handleException(exception: Exception) : ResponseEntity<StudentErrorResponse> {
        val error = StudentErrorResponse(HttpStatus.BAD_REQUEST.value(), exception.message, System.currentTimeMillis())
        return ResponseEntity(error, HttpStatus.BAD_REQUEST)
    }

}