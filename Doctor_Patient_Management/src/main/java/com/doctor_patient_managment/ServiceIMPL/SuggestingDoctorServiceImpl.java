package com.doctor_patient_managment.ServiceIMPL;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

		Optional<Patient> opt = patientRepo.findById(patientId);
		if (opt.isEmpty())
			throw new PatientNotFoundException("patient not found for given id");

		Patient patient = opt.get();
		String symtoms = patient.getSymtom();
		String location = patient.getCity();
		
		
		

		List<Doctor> doctorList = doctorRepo.findAll();
		
		
//getting all doctors of patient's location
		List<Doctor> filteredListBasedOnLacation = doctorList.stream()
				.filter(doctor -> (doctor.getCity().toString().equalsIgnoreCase(location)))
				.collect(Collectors.toList());
		if (filteredListBasedOnLacation.size() == 0) {
			throw new DoctorNotFoundException("We are still waiting to expand to your location");
		}
		
		

		List<Doctor> specialistsBasedOnPatientSymtoms = new ArrayList<>();



		for (Doctor doctor : filteredListBasedOnLacation) {
			String speciality = doctor.getSpeciality().toString();

			if (speciality.equalsIgnoreCase("Orthopedic")) {
				if (symtoms.equalsIgnoreCase("Arthritis") || symtoms.equalsIgnoreCase("Backpain")
						|| symtoms.equalsIgnoreCase("Tissue injuries")) {

					specialistsBasedOnPatientSymtoms.add(doctor);
				}

			}

			else if (speciality.equalsIgnoreCase("Gynecology") && symtoms.equalsIgnoreCase("Dysmenorrhea")) {
				specialistsBasedOnPatientSymtoms.add(doctor);

			} else if (speciality.equalsIgnoreCase("Dermatology")) {
				if (symtoms.equalsIgnoreCase("Skin infection") || symtoms.equalsIgnoreCase("skin burn")) {

					specialistsBasedOnPatientSymtoms.add(doctor);
				}

			} else {
				if (speciality.equalsIgnoreCase("ENT") && symtoms.equalsIgnoreCase("Ear pain")) {
					specialistsBasedOnPatientSymtoms.add(doctor);

				}

			}

		}
		
		if(specialistsBasedOnPatientSymtoms.size()==0) {
			throw new DoctorNotFoundException("There isn’t any doctor present at your location for your symptom");}
		
//		System.out.println(specialistsBasedOnPatientSymtoms);
		
		
		return  specialistsBasedOnPatientSymtoms;
	}
	

}
