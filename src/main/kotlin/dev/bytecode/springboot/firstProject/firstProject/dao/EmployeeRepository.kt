package dev.bytecode.springboot.firstProject.firstProject.dao

import dev.bytecode.springboot.firstProject.firstProject.entity.Employee
import org.springframework.data.jpa.repository.JpaRepository

interface EmployeeRepository: JpaRepository<Employee, Int> {
}