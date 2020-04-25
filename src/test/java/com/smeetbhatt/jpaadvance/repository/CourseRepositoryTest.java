package com.smeetbhatt.jpaadvance.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.smeetbhatt.jpaadvance.JpaAdvanceApplication;
import com.smeetbhatt.jpaadvance.entity.Course;


@SpringBootTest(classes = JpaAdvanceApplication.class)
class CourseRepositoryTest {
	
	@Autowired
	CourseRepository repository;

	//@Test
	void findByIdBasic() {
		Course course = repository.findById(10001L);
		assertEquals("JPA in 50 steps", course.getName());
	}

	//@Test
	//@DirtiesContext //for other test methods data is not changed.
	void deleteByIdBasic() {
		repository.deleteById(10002L);
		assertNull(repository.findById(10002L));
	}

	//@Test
	//@DirtiesContext //for other test methods data is not changed.
	void saveBasic() {
		Course course = repository.findById(10001L);
		course.setName("C/C++");
		repository.save(course);
		course = repository.findById(10001L);
		assertEquals("C/C++", course.getName());
	}
	
	@Test
	@DirtiesContext //for other test methods data is not changed.
	void playWithEntityManager() {
		repository.playWithEntityManager();
	}
}
