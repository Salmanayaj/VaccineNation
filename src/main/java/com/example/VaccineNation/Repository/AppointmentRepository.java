package com.example.VaccineNation.Repository;

import com.example.VaccineNation.Model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

}
