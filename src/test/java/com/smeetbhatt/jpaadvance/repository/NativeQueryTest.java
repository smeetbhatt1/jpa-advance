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
class NativeQueryTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass()); 
	@Autowired
	EntityManager em;

	@Test
	void selectAllBasic() {
		 Query query = em.createNativeQuery("SELECT * FROM COURSE", Course.class);
		 List resultList = query.getResultList();
		logger.info("select c From Course c -> {}", resultList);
	}

	
}
