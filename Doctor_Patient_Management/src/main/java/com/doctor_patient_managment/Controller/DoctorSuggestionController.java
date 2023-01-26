package com.doctor_patient_managment.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctor_patient_managment.Exceptions.DoctorNotFoundException;
import com.doctor_patient_managment.Exceptions.PatientNotFoundException;
import com.doctor_patient_managment.ServiceIMPL.SuggestingDoctorServiceImpl;

@RestController
@RequestMapping("/api")
public class DoctorSuggestionController {
	@Autowired
	private SuggestingDoctorServiceImpl suggestionService;
	
	
	@GetMapping("/suggest/{id}")
	public String checking(@PathVariable("id") Integer id) throws DoctorNotFoundException, PatientNotFoundException {
		
		suggestionService.searchDoctorByPatientId(id);
		return "ok";
	}

}
