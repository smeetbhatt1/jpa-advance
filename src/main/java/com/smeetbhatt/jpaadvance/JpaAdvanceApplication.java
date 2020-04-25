package com.smeetbhatt.jpaadvance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.smeetbhatt.jpaadvance.entity.Course;
import com.smeetbhatt.jpaadvance.repository.CourseRepository;
import com.smeetbhatt.jpaadvance.repository.StudentRepository;

@SpringBootApplication
public class JpaAdvanceApplication implements CommandLineRunner{
	
	@Autowired
	private CourseRepository repository;
	
	@Autowired
	private StudentRepository stdRepository;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(JpaAdvanceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Course course = repository.findById(10001L);
		//logger.info("Course 10001 => {}", course.toString());
		//repository.deleteById(10003L);
		
		//repository.save(new Course("C/C++"));
		
		//repository.playWithEntityManager();
		
		//region Student
		stdRepository.saveStudentWithPassport();
		//endregion
	}

}
