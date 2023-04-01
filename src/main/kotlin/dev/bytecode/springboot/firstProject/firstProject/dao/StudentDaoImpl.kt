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

    override fun findById(id: Int): Student? {
        return entityManager.find(Student::class.java, id)
    }

    override fun findAll(): List<Student> {
        val theQuery = entityManager.createQuery("FROM Student order by lastName desc", Student::class.java)
        return theQuery.resultList
    }

    override fun findByLastName(lastName: String): List<Student> {
        val theQuery = entityManager.createQuery("FROM Student where lastName=:theData", Student::class.java)
        theQuery.setParameter("theData", lastName)
        return theQuery.resultList
    }

    @Transactional
    override fun update(student: Student) {
            entityManager.merge(student)
    }

    @Transactional
    override fun delete(id: Int) {
        val student = entityManager.find(Student::class.java, id)
        entityManager.remove(student)
    }

    @Transactional
    override fun deleteAll(): Int {
        val numOfRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate()
        return numOfRowsDeleted
    }
}