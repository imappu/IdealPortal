package com.application.entity;

import javax.persistence.*;

import com.application.interfaces.IPatient;

/**
 * Entity class for Patient registration details  with getters ,setters and constructor definitions.
 * @author Apparay Shakapure <AS052304>
 * @version    1.0
 *@since       1.0 
 */
@NamedNativeQueries({
		@NamedNativeQuery(name = "findpatient", query = "select * from patiententity s where s.contact = :contact and s.password = :password",

				resultClass = Patient.class)

		,
		@NamedNativeQuery(name = "findcontact", query = "select * from patiententity s where s.contact = :contact", resultClass = Patient.class) }

)

@Entity
@Table(name = "patiententity")
public class Patient implements IPatient{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "firstname")
	private String FirstName;
	@Column(name = "lastname")
	private String LastName;
	@Column(name = "password")
	private String Password;
	@Column(name = "contact", unique = true)
	private String Contact;
	@Column(name = "email", unique = true)
	private String Email;
	@Column(name = "dob")
	private String dob;
	@Column(name = "gender")
	private String Gender;
	@Column(name = "address")
	private String Address;

	public Patient(String firstName, String lastName, String password, String contact, String email, String dob,
			String gender, String address) {
		super();
		FirstName = firstName;
		LastName = lastName;
		Password = password;
		Contact = contact;
		Email = email;
		this.dob = dob;
		Gender = gender;
		Address = address;
	}

	public Patient() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getContact() {
		return Contact;
	}

	public void setContact(String contact) {
		Contact = contact;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

}