package com.example.VaccineNation.Repository;

import com.example.VaccineNation.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
