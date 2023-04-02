package dev.bytecode.springboot.firstProject.firstProject.modal

data class StudentNotFoundException(
    override val message: String? = null,
    override val cause: Throwable? = null
) : RuntimeException()