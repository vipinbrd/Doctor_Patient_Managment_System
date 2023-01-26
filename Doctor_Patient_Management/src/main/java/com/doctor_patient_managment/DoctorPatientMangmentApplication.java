package com.doctor_patient_managment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@SpringBootApplication
public class DoctorPatientMangmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorPatientMangmentApplication.class, args);
	}

}
