package com.application.entity;

/**
 *Entity class for Patient login authentication with getters ,setters and constructor definitions.
 * @author Apparay Shakapure <AS052304>
 * @version    1.0
 *@since       1.0 
 */
public class PatientLogin {
	private String username;
	private String password;

	public PatientLogin() {
		super();
	}

	public PatientLogin(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}