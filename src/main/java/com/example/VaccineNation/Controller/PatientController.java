package com.example.VaccineNation.Controller;

import com.example.VaccineNation.Enum.Gender;
import com.example.VaccineNation.Model.Patient;
import com.example.VaccineNation.Service.PatientService;
import com.example.VaccineNation.dto.request.PatientRequest;
import com.example.VaccineNation.dto.response.PatientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @PostMapping("/add")
    public ResponseEntity addPatient(@RequestBody PatientRequest patientRequest){
        try {
            PatientResponse patientResponse = patientService.addPatient(patientRequest);
            return new ResponseEntity<>(patientResponse, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>("Invalid request", HttpStatus.NOT_ACCEPTABLE);
        }
    }


    @GetMapping("/get")
    public PatientResponse getPatient(@RequestParam("id") int id){
        return patientService.getPatient(id);
    }

    @GetMapping("/get/gender/{gender}")
    public List<PatientResponse> getAllPatientsByGender(@PathVariable("gender") Gender gender){
        return patientService.getAllPatientByGender(gender);

    }
}
