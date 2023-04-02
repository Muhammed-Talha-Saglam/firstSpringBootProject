package dev.bytecode.springboot.firstProject.firstProject.rest

import dev.bytecode.springboot.firstProject.firstProject.entity.Employee
import dev.bytecode.springboot.firstProject.firstProject.service.EmployeeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.RuntimeException

@RestController
@RequestMapping("/api")
class EmployeeRestController @Autowired constructor (
    private val employeeService: EmployeeService
) {

    @GetMapping("/employees")
    fun findAll(): List<Employee> {
        return employeeService.findAll()
    }

    @GetMapping("/employees/{employeeId}")
    fun getEmployee(@PathVariable employeeId: Int): Employee? {
        return employeeService.findById(employeeId) ?: throw RuntimeException("Employee Id not found - $employeeId")
    }

    @PostMapping("/employees")
    fun addEmployee(@RequestBody employee: Employee): Employee? {
       return employeeService.save(employee.apply { id = 0 })
    }

    @PutMapping("/employees")
    fun updateEmployee(@RequestBody employee: Employee): Employee? {
        return employeeService.save(employee)
    }

    @DeleteMapping("/employees/{employeeId}")
    fun deleteEmployee(@PathVariable employeeId: Int): String {
        val employee = employeeService.findById(employeeId) ?: throw RuntimeException("Employee Id not found - $employeeId")

        employeeService.deleteById(employeeId)

        return "Deleted employee - $employeeId"
    }


}