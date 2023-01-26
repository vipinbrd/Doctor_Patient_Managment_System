package com.doctor_patient_managment.Services;

import java.util.List;

import com.doctor_patient_managment.Exceptions.DoctorNotFoundException;
import com.doctor_patient_managment.Exceptions.PatientNotFoundException;
import com.doctor_patient_managment.Model.Doctor;

public interface SuggestingDoctorService {
	
	public List<Doctor> searchDoctorByPatientId(Integer patientId) throws DoctorNotFoundException,PatientNotFoundException;

}
