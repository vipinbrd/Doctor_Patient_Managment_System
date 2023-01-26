package com.doctor_patient_managment.ServiceIMPL;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctor_patient_managment.Exceptions.DoctorNotFoundException;
import com.doctor_patient_managment.Exceptions.PatientNotFoundException;
import com.doctor_patient_managment.Model.Doctor;
import com.doctor_patient_managment.Model.Patient;
import com.doctor_patient_managment.Repository.DoctorRepository;
import com.doctor_patient_managment.Repository.PatientRepository;
import com.doctor_patient_managment.Services.SuggestingDoctorService;

@Service
public class SuggestingDoctorServiceImpl implements SuggestingDoctorService {
@Autowired
private DoctorRepository doctorRepo;
@Autowired
private PatientRepository patientRepo;
	@Override
	public List<Doctor> searchDoctorByPatientId(Integer patientId)
			throws DoctorNotFoundException, PatientNotFoundException {
	
		
	Optional<Patient>opt=	patientRepo.findById(patientId);
	if(opt.isEmpty())throw new PatientNotFoundException("patient not found for given id");

	 Patient patient=opt.get();
	 String symtoms=patient.getSymtom();
	 String location=patient.getCity();
	 System.out.println(symtoms);
	 System.out.println(location);
	
		
	
		
		
		return null;
	}

}
