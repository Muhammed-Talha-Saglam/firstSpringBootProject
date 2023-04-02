package dev.bytecode.springboot.firstProject.firstProject.service

import dev.bytecode.springboot.firstProject.firstProject.entity.Employee

interface EmployeeService {
    fun save(employee: Employee): Employee?

    fun findById(id: Int): Employee?

    fun findAll(): List<Employee>

    fun deleteById(id: Int)
}