package com.doctor_patient_managment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doctor_patient_managment.Model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {

}
