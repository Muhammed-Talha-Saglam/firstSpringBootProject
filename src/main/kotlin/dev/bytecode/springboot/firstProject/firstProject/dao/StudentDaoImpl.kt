package dev.bytecode.springboot.firstProject.firstProject.dao

import dev.bytecode.springboot.firstProject.firstProject.entity.Student
import jakarta.persistence.EntityManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
class StudentDaoImpl(
    @Autowired private val entityManager: EntityManager
): StudentDao {


    @Transactional
    override fun save(student: Student) {
        entityManager.persist(student)
    }
}