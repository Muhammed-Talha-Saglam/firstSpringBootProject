package dev.bytecode.springboot.firstProject.firstProject.service

import dev.bytecode.springboot.firstProject.firstProject.dao.EmployeeRepository
import dev.bytecode.springboot.firstProject.firstProject.entity.Employee
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.RuntimeException
import kotlin.jvm.optionals.getOrNull

@Service
class EmployeeServiceImpl constructor (
    private val employeeRepository: EmployeeRepository
): EmployeeService {

    override fun save(employee: Employee): Employee? {
        return employeeRepository.save(employee)
    }

    override fun findById(id: Int): Employee? {
        val employee = employeeRepository.findById(id).getOrNull()
        return employee ?: throw RuntimeException("Did not find employee - $id")
    }

    override fun findAll(): List<Employee> {
        return employeeRepository.findAll()
    }

    override fun deleteById(id: Int) {
        employeeRepository.deleteById(id)
    }

}