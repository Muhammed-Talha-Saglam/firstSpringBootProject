package dev.bytecode.springboot.firstProject.firstProject.dao

import dev.bytecode.springboot.firstProject.firstProject.entity.Student

interface StudentDao {

    fun save(student: Student)
}