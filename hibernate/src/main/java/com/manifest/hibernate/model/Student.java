/*
 * 
 * This file models the data object by defining variables, constructors, getters, and setters. Overrides toString, hashCode, and equals.
 * The annotations in this model are used by spring.jpa.hibernate.ddl-auto in the application.properties file to define a database table and columns.
 * 
 */

package com.manifest.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="student_info")
public class Student {
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private double gpa;
	
	public Student() {
	}
	

	public Student(int id, String firstName, String lastName, String email, double gpa) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gpa = gpa;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="first_name")
	@NotNull
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name="last_name")
	@NotNull
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name="email")
	@NotNull
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="gpa")
	@NotNull
	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	
	@Override
	public String toString() {
		return "Student [id=" + id + ", first_name=" + firstName + ", last_name=" + lastName + ", email=" + email
				+ ", gpa=" + gpa + "]";
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(gpa);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (Double.doubleToLongBits(gpa) != Double.doubleToLongBits(other.gpa))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
	
	

}
