package com.example.VaccineNation.Repository;

import com.example.VaccineNation.Model.Dose;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoseRepository extends JpaRepository<Dose, Integer> {

}
