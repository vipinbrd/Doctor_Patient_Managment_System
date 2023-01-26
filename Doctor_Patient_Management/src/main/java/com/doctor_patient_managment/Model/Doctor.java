package com.doctor_patient_managment.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer doctorId;
	
	@Size(min = 3, message = "name should atleast 3 character")
	private String doctorName;
	
	@Column(columnDefinition = "VARCHAR(30)")
	@Enumerated(EnumType.STRING)
	private City city;
	
	@Email(message = "please use valid email address")
	private String email;
	
	@Pattern(regexp="(^$|[0-9]{10})", message = "please enter valid phone number")
	private String phoneNumber;
	
	@Column(columnDefinition = "VARCHAR(30)")
	@Enumerated(EnumType.STRING)
	private Speciality speciality;



	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
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

	public Speciality getSpeciality() {
		return speciality;
	}

	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}
	
	public Doctor(@Size(min = 3, message = "name should atleast 3 character") String doctorName,
			@Size(max = 20, message = "city name should not be more than 20 character") City city,
			@Email(message = "please use valid email address") String email,
			@Pattern(regexp="(^$|[0-9]{10})", message = "please enter valid phone number") String phoneNumber,
			Speciality speciality) {
		super();
		this.doctorName = doctorName;
		this.city = city;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.speciality = speciality;
	}
	
	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", city=" + city + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", speciality=" + speciality + "]";
	}
}
