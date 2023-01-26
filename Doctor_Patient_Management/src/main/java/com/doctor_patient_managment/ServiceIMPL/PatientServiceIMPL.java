package com.doctor_patient_managment.ServiceIMPL;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctor_patient_managment.Exceptions.DoctorNotFoundException;
import com.doctor_patient_managment.Exceptions.PatientNotFoundException;
import com.doctor_patient_managment.Model.Doctor;
import com.doctor_patient_managment.Model.Patient;
import com.doctor_patient_managment.Repository.PatientRepository;
import com.doctor_patient_managment.Services.PatientService;

@Service
public class PatientServiceIMPL  implements PatientService{
@Autowired
private PatientRepository patientRepo;

	@Override
	public Patient savePatient(Patient ptn) {
		Patient patient=patientRepo.save(ptn);
		return patient;
	}

	@Override
	public Patient removePatient(Integer PatientId) throws PatientNotFoundException {
		Optional<Patient> opt = patientRepo.findById(PatientId);
		if (opt.isEmpty())
			throw new PatientNotFoundException("Patient not found to given id");
		else
			return opt.get();
	}

}
