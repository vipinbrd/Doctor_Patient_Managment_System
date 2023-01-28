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
import com.doctor_patient_managment.Model.Doctor;
import com.doctor_patient_managment.Services.DoctorServiceImpl;




@RestController
@RequestMapping("/api")
public class DoctorController {
	@Autowired
	private DoctorServiceImpl doctorService;
	
	@PostMapping("/doctor")
	public ResponseEntity<Doctor> saveDoctor(@RequestBody @Valid Doctor doct){
	Doctor doctor=doctorService.addDoctor(doct);
	
		return new ResponseEntity<Doctor>(doctor,HttpStatus.CREATED);
		
	}
	@DeleteMapping("/doctor/{doctorId}")
	public ResponseEntity<Doctor> removeDoctor(@PathVariable("doctorId") Integer id)
			throws DoctorNotFoundException{
	Doctor doctor=doctorService.removeDoctor(id);
	
		return new ResponseEntity<Doctor>(doctor,HttpStatus.CREATED);
		
	}

}
