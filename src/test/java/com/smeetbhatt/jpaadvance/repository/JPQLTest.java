package com.smeetbhatt.jpaadvance.repository;


import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.smeetbhatt.jpaadvance.JpaAdvanceApplication;
import com.smeetbhatt.jpaadvance.entity.Course;


@SpringBootTest(classes = JpaAdvanceApplication.class)
class JPQLTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass()); 
	@Autowired
	EntityManager em;

	//@Test
	void selectAllBasic() {
		List resultList = em.createQuery("Select c From Course c").getResultList();
		logger.info("select c From Course c -> {}", resultList);
	}

	//@Test
	void selectAllTypedQuery() {
		TypedQuery<Course> query = em.createQuery("Select c From Course c", Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("select c From Course c -> {}", resultList);
	}

	@Test
	void findById() {
		TypedQuery<Course> query = em.createQuery("Select c From Course c Where name like '%100%'", Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("select c From Course c Where name like '%100%' -> {}", resultList);
	}
	
	@Test
	void findAllWithNamedQuery() {
		Query query = em.createNamedQuery("get_all_courses");
		List resultList = query.getResultList();
		logger.info("select c From Course c -> {}", resultList);
	}
}
