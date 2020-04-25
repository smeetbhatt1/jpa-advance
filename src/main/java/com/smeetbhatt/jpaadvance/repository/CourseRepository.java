package com.smeetbhatt.jpaadvance.repository;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.smeetbhatt.jpaadvance.entity.Course;

@Repository
@Transactional
public class CourseRepository {

	@Autowired
	EntityManager entityManager;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public Course findById(long id) {
		return entityManager.find(Course.class, id);
	}
	
	public Course save(Course course) {
		if (course.getId() == 0) { //insert
			entityManager.persist(course);
		}
		else { //update
			entityManager.merge(course);
		}
		return course;
	}
	
	public void deleteById(long id) {
		Course course = findById(id);
		entityManager.remove(course);
	}
	
	public void playWithEntityManagerNew() {
		Course course1 = new Course("Flutter in 100 steps");
		entityManager.persist(course1); //insert query fired.
		
		
		Course course2 = new Course("Angular in 100 steps");
		entityManager.persist(course2); //insert query fired.
		entityManager.flush();
		
		//entityManager.detach(course2); //detach is used on single object
		//entityManager.clear(); //clear is used on every single object is available

	
		course1.setName("Flutter in 100 steps - Updated"); //update query fired. because we have transaction annotation
		course2.setName("Angular in 100 steps - Updated"); //update query fired. because we have transaction annotation
		
		entityManager.refresh(course1);
		entityManager.flush();
	}
	
	public void playWithEntityManager() {
		Course course1 = new Course("Flutter in 100 steps");
		entityManager.persist(course1); //insert query fired.

		Course course2 = findById(10001L);
		course2.setName("Smeet");
	}
}
