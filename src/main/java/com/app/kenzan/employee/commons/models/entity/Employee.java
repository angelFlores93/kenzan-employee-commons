package com.app.kenzan.employee.commons.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.app.kenzan.employee.commons.utils.Status;

/**
 * 
 * @author aaflo
 *
 */
@Entity
@Table(name = "employees")
public class Employee implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	private String firstName;
	private char middleInitial;
	private String lastName;
	@Temporal(TemporalType.DATE)
	private Date dateOfEmployment;
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	@Enumerated (EnumType.STRING)
	private Status status;

	protected Employee() {
	}

	public static EmployeeBuilder builder() {
		return new EmployeeBuilder();
	}

	private Employee(String firstName, char middleInitial, String lastName, Date dateOfEmployment, Date dateOfBirth,
			Status status) {
		this.setFirstName(firstName);
		this.setMiddleInitial(middleInitial);
		this.setLastName(lastName);
		this.setDateOfEmployment(dateOfEmployment);
		this.setDateOfBirth(dateOfBirth);
		this.setStatus(status);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public char getMiddleInitial() {
		return middleInitial;
	}

	public void setMiddleInitial(char middleInitial) {
		this.middleInitial = middleInitial;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfEmployment() {
		return dateOfEmployment;
	}

	public void setDateOfEmployment(Date dateOfEmployment) {
		this.dateOfEmployment = dateOfEmployment;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	//Builder pattern to instantiate users on creation easier
	//against having constructor with many arguments
	public static class EmployeeBuilder {
		private String firstName;
		private char middleInitial;
		private String lastName;
		private Date dateOfEmployment;
		private Date dateOfBirth;
		private Status status;

		public EmployeeBuilder fisrtName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public EmployeeBuilder middleInitial(char middleInitial) {
			this.middleInitial = middleInitial;
			return this;
		}

		public EmployeeBuilder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public EmployeeBuilder dateOfEmployment(Date dateOfEmployment) {
			this.dateOfEmployment = dateOfEmployment;
			return this;
		}

		public EmployeeBuilder dateOfBirth(Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
			return this;
		}

		public EmployeeBuilder status(Status status) {
			this.status = status;
			return this;
		}

		public Employee build() {
			return new Employee(firstName, middleInitial, lastName, dateOfEmployment, dateOfBirth, status);
		}
	}
}