package com.example.VaccineNation.Service;


import com.example.VaccineNation.Enum.Gender;
import com.example.VaccineNation.Exception.PatientNotFoundException;
import com.example.VaccineNation.Model.Patient;
import com.example.VaccineNation.Repository.PatientRepository;
import com.example.VaccineNation.dto.request.PatientRequest;
import com.example.VaccineNation.dto.response.PatientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;
    public PatientResponse addPatient(PatientRequest patientRequest) {

        // 1. request dto to model/entity
        Patient patient = new Patient();
        patient.setVaccinated(false);
        patient.setName(patientRequest.getName());
        patient.setAge(patientRequest.getAge());
        patient.setGender(patientRequest.getGender());

         Patient savedPatient = patientRepository.save(patient);

         //2. convert model/entity to dto
        PatientResponse patientResponse = new PatientResponse();git
        patientResponse.setName(savedPatient.getName());
        patientResponse.setVaccinated(savedPatient.isVaccinated());
        patientResponse.setEmailid(savedPatient.getEmailId());

        return patientResponse;
    }

    public PatientResponse getPatient(int id) {
       Optional<Patient> patientOptional = patientRepository.findById(id);

       if(patientOptional.isEmpty()){
           throw new PatientNotFoundException("Invalid Patient id");
       }
       Patient patient = patientOptional.get();
       PatientResponse patientResponse = new PatientResponse();
       patientResponse.setName(patient.getName());
       patientResponse.setVaccinated(patient.isVaccinated());
       patientResponse.setEmailid(patient.getEmailId());
        return patientResponse;

    }


    public List<PatientResponse> getAllPatientByGender(Gender gender) {

        List<Patient> patients = patientRepository.findAll();

        List<PatientResponse> patientResponses = new ArrayList<>();
        for(Patient patient : patients){
            if(patient.getGender() == gender){
                PatientResponse patientResponse = new PatientResponse();
                patientResponse.setName(patient.getName());
                patientResponse.setVaccinated(patient.isVaccinated());
                patientResponse.setEmailid(patient.getEmailId());
            }
        }
        return patientResponses;
    }
}
