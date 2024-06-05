package com.example.VaccineNation.Service;

import com.example.VaccineNation.Enum.VaccineBrand;
import com.example.VaccineNation.Exception.PatientNotFoundException;
import com.example.VaccineNation.Model.Dose;
import com.example.VaccineNation.Model.Patient;
import com.example.VaccineNation.Repository.DoseRepository;
import com.example.VaccineNation.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DoseService {

    @Autowired
    DoseRepository doseRepository;
    @Autowired
     PatientRepository patientRepository;
    public Dose addDose(int patientid, VaccineBrand vaccinebrand) {
        Optional<Patient> patientOptional = patientRepository.findById(patientid);
        if(patientOptional.isEmpty()){
            throw new PatientNotFoundException("Invalid Patient id");
        }
       Patient patient = patientOptional.get();
        if(patient.isVaccinated()){
            throw new RuntimeException("Patient is already vaccinated");
        }

        patient.setVaccinated(true);

        Dose dose = new Dose();
        dose.setVaccineBrand(vaccinebrand);
        dose.setSerialNumber(String.valueOf(UUID.randomUUID()));
        dose.setPatient(patient);

        patientRepository.save(patient);
        return doseRepository.save(dose);
    }
}
