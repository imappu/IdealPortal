package com.application.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

/**
 *Entity class for Doctor  registration details with getters ,setters and constructor definitions.
 * @author Apparay Shakapure <AS052304>
 * @version    1.0
 *@since       1.0 
 */
@NamedNativeQueries({
		@NamedNativeQuery(name = "doctorauth", query = "select * from doctorentity d where d.doctorid = :doctorid ", resultClass = Doctor.class) })

@Entity
@Table(name = "doctorentity")

public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "doctorid")
	private int doctorid;

	@Column(name = "name")
	private String doctorname;

	@Column(name = "department")
	private String department;

	@Column(name = "qualification")
	private String qualification;

	public Doctor(String doctorname, String department, String qualification) {
		super();
		this.doctorname = doctorname;
		this.department = department;
		this.qualification = qualification;
	}

	public Doctor() {
		super();
	}

	public int getDoctorid() {
		return doctorid;
	}

	public void setDoctorid(int doctorid) {
		this.doctorid = doctorid;
	}

	public String getDoctorname() {
		return doctorname;
	}

	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

}
