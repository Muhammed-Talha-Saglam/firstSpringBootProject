package dev.bytecode.springboot.firstProject.firstProject.dao

import dev.bytecode.springboot.firstProject.firstProject.entity.Student

interface StudentDao {

    fun save(student: Student)

    fun findById(id: Int): Student?

    fun findAll(): List<Student>

    fun findByLastName(lastName: String): List<Student>

    fun update(student: Student)

    fun delete(id: Int)

    fun deleteAll(): Int
}