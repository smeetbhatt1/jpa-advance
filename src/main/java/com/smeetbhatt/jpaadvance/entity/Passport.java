package com.smeetbhatt.jpaadvance.entity;

import javax.persistence.*;

@Entity
public class Passport {

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false)
	private String number;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")
	/*
	 * If we don't add "mappedBy", then student table will have passport_id
	 * and passport table will have student_id
	 * But we only want Student to be the owning table of passport not vice versa
	 */
	private Student student;

	protected Passport() {
	}

	public Passport(String number) {
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public long getId() {
		return id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Passport [number=" + number + "]";
	}

}
