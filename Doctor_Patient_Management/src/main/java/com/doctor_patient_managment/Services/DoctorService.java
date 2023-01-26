package com.doctor_patient_managment.Services;

import com.doctor_patient_managment.Exceptions.DoctorNotFoundException;
import com.doctor_patient_managment.Model.Doctor;

public interface DoctorService {
	public Doctor addDoctor(Doctor doctor);
	public Doctor removeDoctor(Integer doctorId) throws DoctorNotFoundException;

}
