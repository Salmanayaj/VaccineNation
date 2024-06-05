package com.example.VaccineNation.Repository;

import com.example.VaccineNation.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
}
