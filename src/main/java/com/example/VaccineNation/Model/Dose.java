package com.example.VaccineNation.Model;

import com.example.VaccineNation.Enum.VaccineBrand;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Dose {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String serialNumber;   //UUID

    @Enumerated(value = EnumType.STRING)
    private VaccineBrand vaccineBrand;

    @CreationTimestamp
    private Date dateOfAppointment;

    @OneToOne   // current class to connecting class (i,e. Dose to Patient)
    @JoinColumn  // create a foreign key as patient id
    Patient patient;

}
