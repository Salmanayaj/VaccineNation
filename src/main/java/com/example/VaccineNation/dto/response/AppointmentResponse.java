package com.example.VaccineNation.dto.response;

import com.example.VaccineNation.Enum.AppointmentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AppointmentResponse {

    private String appointmentid;

    private Date dateOfAppointment;

    private AppointmentStatus status;

    private PatientResponse patientResponse;

    private String doctorName;
}
