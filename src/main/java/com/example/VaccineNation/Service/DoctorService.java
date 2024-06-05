package com.example.VaccineNation.Service;

import com.example.VaccineNation.Exception.DoctorNotFoundException;
import com.example.VaccineNation.Model.Doctor;
import com.example.VaccineNation.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;
    public String addDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
        return "Doctor has been registered successfully";
    }

    public Doctor getDoctor(int id) {
        Optional<Doctor> doctorOptional = doctorRepository.findById(id);

        if(doctorOptional.isEmpty()){
            throw new DoctorNotFoundException("Invalid Doctor id");
        }
        Doctor doctor = doctorOptional.get();
        return doctor;
    }

    public String deleteDoctor(int id) {
        doctorRepository.deleteById(id);
        return "Doctor has been deleted";
    }
}
