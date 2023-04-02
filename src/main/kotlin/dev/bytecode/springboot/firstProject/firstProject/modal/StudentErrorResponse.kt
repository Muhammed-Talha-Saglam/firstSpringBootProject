package dev.bytecode.springboot.firstProject.firstProject.modal

data class StudentErrorResponse(
    val status: Int,
    val message: String? = null,
    val timeStamp: Long
)