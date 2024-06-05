package com.example.VaccineNation.Service;

import com.example.VaccineNation.Enum.AppointmentStatus;
import com.example.VaccineNation.Exception.DoctorNotFoundException;
import com.example.VaccineNation.Exception.PatientNotFoundException;
import com.example.VaccineNation.Model.Appointment;
import com.example.VaccineNation.Model.Doctor;
import com.example.VaccineNation.Model.Patient;
import com.example.VaccineNation.Repository.AppointmentRepository;
import com.example.VaccineNation.Repository.DoctorRepository;
import com.example.VaccineNation.Repository.PatientRepository;
import com.example.VaccineNation.dto.response.AppointmentResponse;
import com.example.VaccineNation.dto.response.PatientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.Optional;
import java.util.UUID;

@Service
public class AppointmentService {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    AppointmentRepository appointmentRepository;

    public AppointmentResponse bookAppointment(int patientid, int doctorid) {

        Optional<Patient> patientOptional = patientRepository.findById(patientid);

        if(patientOptional.isEmpty()){
            throw new PatientNotFoundException("Invalid Patient id");
        }
        Optional<Doctor> doctorOptional = doctorRepository.findById(doctorid);

        if(doctorOptional.isEmpty()){
            throw new DoctorNotFoundException("Invalid Doctor id");
        }

        Patient patient = patientOptional.get();
        Doctor doctor = doctorOptional.get();

        // book the appointment
        Appointment appointment = new Appointment();
        appointment.setAppointmentId(String.valueOf(UUID.randomUUID()));
        appointment.setStatus(AppointmentStatus.BOOKED);
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        Appointment savedAppointment = appointmentRepository.save(appointment);

        AppointmentResponse appointmentResponse = new AppointmentResponse();
        appointmentResponse.setAppointmentid(savedAppointment.getAppointmentId());
        appointmentResponse.setStatus(savedAppointment.getStatus());
        appointmentResponse.setDateOfAppointment(savedAppointment.getDateOfAppointment());
        appointmentResponse.setDoctorName(savedAppointment.getDoctor().getName());

        Patient savedPatient = savedAppointment.getPatient();
        PatientResponse patientResponse = new PatientResponse();
        patientResponse.setName(savedPatient.getName());
        patientResponse.setVaccinated(savedPatient.isVaccinated());
        patientResponse.setEmailid(savedPatient.getEmailId());

        appointmentResponse.setPatientResponse(patientResponse);

        return appointmentResponse;

    }
}
