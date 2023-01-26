package com.doctor_patient_managment.Model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer patientId;
	
	@Size(min = 3, message = "name should atleast 3 character")
	private String patientName;
	
	@Size(max = 20, message = "city name should not be more than 20 character")
	private String city;
	
	@Email(message = "please use valid email address")
	private String email;
	
	@Pattern(regexp = "^\\{10}$", message = "please enter valid phone number")
	private String phoneNumber;
	
	private String symtom;

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", city=" + city + ", email="
				+ email + ", phoneNumber=" + phoneNumber + ", symtom=" + symtom + "]";
	}

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSymtom() {
		return symtom;
	}

	public void setSymtom(String symtom) {
		this.symtom = symtom;
	}

	public Patient(@Size(min = 3, message = "name should atleast 3 character") String patientName,
			@Size(max = 20, message = "city name should not be more than 20 character") String city,
			@Email(message = "please use valid email address") String email,
			@Pattern(regexp = "^\\{10}$", message = "please enter valid phone number") String phoneNumber,
			String symtom) {
		super();
		this.patientName = patientName;
		this.city = city;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.symtom = symtom;
	}
}
