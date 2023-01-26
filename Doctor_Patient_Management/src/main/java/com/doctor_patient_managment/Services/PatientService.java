package com.doctor_patient_managment.Services;

import com.doctor_patient_managment.Exceptions.PatientNotFoundException;
import com.doctor_patient_managment.Model.Patient;

public interface PatientService {
public Patient savePatient(Patient patient);
public Patient removePatient(Integer PatientId) throws PatientNotFoundException;

}
