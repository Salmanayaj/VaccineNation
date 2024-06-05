package com.example.VaccineNation.Controller;

import com.example.VaccineNation.Model.Appointment;
import com.example.VaccineNation.Repository.PatientRepository;
import com.example.VaccineNation.Service.AppointmentService;
import com.example.VaccineNation.dto.response.AppointmentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/book")
    public ResponseEntity bookAppointment(@RequestParam("pid") int patientid,
                                          @RequestParam("did") int doctorid){

        try {
            AppointmentResponse bookedAppointment = appointmentService.bookAppointment(patientid,doctorid);
            return new ResponseEntity(bookedAppointment, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
        }
    }

}
