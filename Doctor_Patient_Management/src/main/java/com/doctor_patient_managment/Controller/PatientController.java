package com.doctor_patient_managment.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctor_patient_managment.Exceptions.DoctorNotFoundException;
import com.doctor_patient_managment.Exceptions.PatientNotFoundException;
import com.doctor_patient_managment.Model.Doctor;
import com.doctor_patient_managment.Model.Patient;
import com.doctor_patient_managment.Services.PatientServiceIMPL;



@RestController
@RequestMapping("/api")
public class PatientController {
	@Autowired
	private PatientServiceIMPL patientService;
	
	@PostMapping("/patient")
	public ResponseEntity<Patient> savePatient(@RequestBody @Valid Patient ptn){
	Patient patient=patientService.savePatient(ptn);
	
		return new ResponseEntity<Patient>(patient,HttpStatus.CREATED);
		
	}
	@DeleteMapping("/patient/{patientId}")
	public ResponseEntity<Patient> removePatient(@PathVariable("patientId") Integer id)
			throws PatientNotFoundException{
	Patient patient=patientService.removePatient(id);
	
		return new ResponseEntity<Patient>(patient,HttpStatus.CREATED);
		
	}

}
