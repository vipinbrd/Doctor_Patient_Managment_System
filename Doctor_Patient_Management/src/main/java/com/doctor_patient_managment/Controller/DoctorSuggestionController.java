package com.doctor_patient_managment.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctor_patient_managment.Exceptions.DoctorNotFoundException;
import com.doctor_patient_managment.Exceptions.PatientNotFoundException;
import com.doctor_patient_managment.Model.Doctor;
import com.doctor_patient_managment.Services.SuggestingDoctorServiceImpl;


@RestController
@RequestMapping("/api")
public class DoctorSuggestionController {
	@Autowired
	private SuggestingDoctorServiceImpl suggestionService;
	
@GetMapping("/doctors/{patientId}")
  public ResponseEntity<List<Doctor>> getAllSuggestedDoctor(@PathVariable("patientId") Integer id) throws DoctorNotFoundException, PatientNotFoundException{
	
	
		List<Doctor>  doctors = suggestionService.searchDoctorByPatientId(id);
	
	return new ResponseEntity<List<Doctor>>(doctors,HttpStatus.OK);
}
}
