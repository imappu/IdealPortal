package com.bean.builder;

import com.application.entity.Doctor;

/**
 * @author Apparay Shakapure <AS052304>
 * @version    1.0
 *@since       1.0 
 */
public class DoctorBuilder {
/**
 * Builds Doctor instance with Doctor class contructor. 
 * @param doctorName
 * @param department
 * @param qualification
 * @return
 */
	public Doctor buildDoctor(String doctorName, String department, String qualification)

	{
		Doctor doctor = new Doctor(doctorName, department, qualification);

		return doctor;
	}
}
