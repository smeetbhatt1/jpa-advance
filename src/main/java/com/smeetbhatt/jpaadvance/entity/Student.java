package com.smeetbhatt.jpaadvance.entity;

import javax.persistence.*;

@Entity
public class Student {

	@Id
	@GeneratedValue
	private long id;
	@Column(nullable = false)
	private String name;
	@OneToOne(fetch = FetchType.LAZY) //bydefault is EAGER
	private Passport passport;

	protected Student() {
	}

	public Student(String name) {
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

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + "]";
	}

}
