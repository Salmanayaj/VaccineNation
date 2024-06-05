package com.example.VaccineNation.Model;

import com.example.VaccineNation.Enum.AppointmentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String appointmentId;

    @CreationTimestamp
    private Date dateOfAppointment;

    @Enumerated(value = EnumType.STRING)
    private AppointmentStatus Status;

    @ManyToOne
    @JoinColumn // to create Foreign Key
    Doctor doctor;

    @OneToOne
    @JoinColumn  // to create Foreign Key
    Patient patient;
}
