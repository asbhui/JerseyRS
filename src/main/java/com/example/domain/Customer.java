package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Customer{

	@Id
	@GeneratedValue
	private Long id;
	
	private String firstname, lastname;
	
	@OneToOne
	@JoinColumn(name="email_id")
	private EmailAddress email;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstname(String firstName) {
		this.firstname = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastname(String lastName) {
		this.lastname = lastName;
	}

	/**
	 * @return the email
	 */
	public EmailAddress getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(EmailAddress email) {
		this.email = email;
	}

}
