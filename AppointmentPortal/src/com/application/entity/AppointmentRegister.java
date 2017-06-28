package com.application.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

/**
 * Entity class for Appointment registration details with getters ,setters and constructor definitions.
 * @author Apparay Shakapure <AS052304>
 * @version    1.0
 *@since       1.0 
 */
@Entity
@NamedNativeQueries({
		@NamedNativeQuery(name = "getavailability", query = "select * from Doctor d where d.department = :department and d.timeslot = :password", resultClass = Doctor.class),
		@NamedNativeQuery(name = "appoint", query = "select * from AppointmentRegister", resultClass = AppointmentRegister.class)

})


public class AppointmentRegister {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "aid")
	private int aid;
	@Column
	private String department;
	@Column
	private String doctorname;
	@Column
	private int employeeid;
	@Column
	private String bookeddate;
	@Column
	private String slot01;
	@Column
	private String slot02;
	@Column
	private String slot03;
	@Column
	private String slot04;

	public AppointmentRegister(String department, String doctorname, int employeeid, String bookeddate, String slot01,
			String slot02, String slot03, String slot04) {
		super();
		this.department = department;
		this.doctorname = doctorname;
		this.employeeid = employeeid;
		this.bookeddate = bookeddate;
		this.slot01 = slot01;
		this.slot02 = slot02;
		this.slot03 = slot03;
		this.slot04 = slot04;
	}

	public AppointmentRegister() {
		super();
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDoctorname() {
		return doctorname;
	}

	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}

	public int getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}

	public String getBookeddate() {
		return bookeddate;
	}

	public void setBookeddate(String bookeddate) {
		this.bookeddate = bookeddate;
	}

	public String getSlot01() {
		return slot01;
	}

	public void setSlot01(String slot01) {
		this.slot01 = slot01;
	}

	public String getSlot02() {
		return slot02;
	}

	public void setSlot02(String slot02) {
		this.slot02 = slot02;
	}

	public String getSlot03() {
		return slot03;
	}

	public void setSlot03(String slot03) {
		this.slot03 = slot03;
	}

	public String getSlot04() {
		return slot04;
	}

	public void setSlot04(String slot04) {
		this.slot04 = slot04;
	}

}
