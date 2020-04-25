package com.smeetbhatt.jpaadvance.repository;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.smeetbhatt.jpaadvance.entity.Passport;
import com.smeetbhatt.jpaadvance.entity.Student;

@Repository
@Transactional
public class StudentRepository {

	@Autowired
	EntityManager entityManager;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public Student findById(long id) {
		return entityManager.find(Student.class, id);
	}
	
	public Student save(Student student) {
		if (student.getId() == 0) { //insert
			entityManager.persist(student);
		}
		else { //update
			entityManager.merge(student);
		}
		return student;
	}
	
	public void deleteById(long id) {
		Student student = findById(id);
		entityManager.remove(student);
	}
	
	public void playWithEntityManagerNew() {
		Student student1 = new Student("Flutter in 100 steps");
		entityManager.persist(student1); //insert query fired.
		
		
		Student student2 = new Student("Angular in 100 steps");
		entityManager.persist(student2); //insert query fired.
		entityManager.flush();
		
		//entityManager.detach(student2); //detach is used on single object
		//entityManager.clear(); //clear is used on every single object is available

	
		student1.setName("Flutter in 100 steps - Updated"); //update query fired. because we have transaction annotation
		student2.setName("Angular in 100 steps - Updated"); //update query fired. because we have transaction annotation
		
		entityManager.refresh(student1);
		entityManager.flush();
	}
	
	public void playWithEntityManager() {
		Student student1 = new Student("Flutter in 100 steps");
		entityManager.persist(student1); //insert query fired.

		Student student2 = findById(10001L);
		student2.setName("Smeet");
	}
	
	public void saveStudentWithPassport() {
		Passport passport = new Passport("Z123456");
		entityManager.persist(passport);
		
		Student student = new Student("Smeet");
		student.setPassport(passport);
		entityManager.persist(student);
	}
	
	public void getStudentWithPassport() {
		//Database Operation 1 - Retrieve Student
		Student student = entityManager.find(Student.class, 20001L);
		//Persistence Context(student)
		
		//Database Operation 2 - Retrieve passport
		Passport passport = student.getPassport();
		//Persistence Context(student, passport)
		
		//Database Operation 3 - update passport
		passport.setNumber("E123457");
		//Persistence Context(student, passport++)
		
		//Database Operation 4 - update Student
		student.setName("Ranga Updated");
		//Persistence Context(student++, passport++)
		
	}
}
