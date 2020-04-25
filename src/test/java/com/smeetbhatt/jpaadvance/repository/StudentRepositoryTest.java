package com.smeetbhatt.jpaadvance.repository;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.smeetbhatt.jpaadvance.JpaAdvanceApplication;
import com.smeetbhatt.jpaadvance.entity.Passport;
import com.smeetbhatt.jpaadvance.entity.Student;


@SpringBootTest(classes = JpaAdvanceApplication.class)
class StudentRepositoryTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass()); 
	@Autowired
	StudentRepository repository;
	
	@Autowired
	EntityManager em;

	//@Test
	
	/*@Transactional //Persistence Context
	/*
	 * if any of the operation is failed below the then the
	 * operations previous succeeded will be roll back.
	 * In overall if all operations should be successfully run
	 * then only it will commit to db. THIS IS BECAUSE WE USED
	 * @TRANSACTIONAL 
	 */
	void getStudentWithPassport() {
		repository.getStudentWithPassport();
	}

	//@Test
	//@Transactional
	public void getStudentAndPassport() {
		Student student = em.find(Student.class, 20001L);
		logger.info("student -> {}", student);
		logger.info("passport -> {}", student.getPassport());
	}
	
	@Test
	@Transactional
	public void getStudentFromPassport() {
		Passport passport = em.find(Passport.class, 40001L);
		logger.info("passport -> {}", passport);
		logger.info("student -> {}", passport.getStudent());
	}
}
