package dev.bytecode.springboot.firstProject.firstProject.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "employee")
class Employee(
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id")
     var id: Int? = null,

     @Column(name = "first_name")
     var firstName: String? = null,

     @Column(name = "last_name")
     var lastName: String? = null,

     @Column(name = "email")
     var email: String? = null
)
