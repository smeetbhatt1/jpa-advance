package com.smeetbhatt.jpaadvance.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "Course") // if no table annotation is provided then its bydefault class name
/*
 * @Table(name="course_details") then in sql query it will be course_details
 * 
 * @Table(name="CourseDetails") then in sql query it will be course_details
 */

/*
 * We cannot have more than one NamedQuery, so we use NamedQueries
 */
@NamedQueries(value = {
		@NamedQuery(name = "get_all_courses", query = "Select c From Course c"),
		@NamedQuery(name = "get_all_courses_", query = "Select c From Course c") }
)
public class Course {

	@Id
	@GeneratedValue
	private long id;

	@Column(name = "name", nullable = false)
	private String name;

	@UpdateTimestamp
	private LocalDateTime updatedDate;
	@CreationTimestamp
	private LocalDateTime createdDate;

	protected Course() {
	}

	public Course(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Course [name=" + name + "]";
	}

}
