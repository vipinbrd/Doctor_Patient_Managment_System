package com.doctor_patient_managment.ServiceIMPL;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctor_patient_managment.Exceptions.DoctorNotFoundException;
import com.doctor_patient_managment.Model.Doctor;
import com.doctor_patient_managment.Repository.DoctorRepository;
import com.doctor_patient_managment.Services.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {
	@Autowired
	private DoctorRepository doctorRepo;

	@Override
	public Doctor addDoctor(Doctor doc) {
		Doctor doctor = doctorRepo.save(doc);
		return doctor;
	}

	@Override
	public Doctor removeDoctor(Integer doctorId) throws DoctorNotFoundException {
		Optional<Doctor> opt = doctorRepo.findById(doctorId);
		if (opt.isEmpty())
			throw new DoctorNotFoundException("Doctor not found to given id");
		else {
			doctorRepo.deleteById(doctorId);
		}
			return opt.get();
	}

}
