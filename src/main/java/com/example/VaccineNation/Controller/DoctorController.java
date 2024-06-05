package com.example.VaccineNation.Controller;

import com.example.VaccineNation.Model.Doctor;
import com.example.VaccineNation.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;
    @PostMapping("/add")
    public String addDoctor(@RequestBody Doctor doctor){
        return doctorService.addDoctor(doctor);
    }

    @GetMapping("/get")
    public Doctor getDoctor(@RequestParam("id") int id){
        return doctorService.getDoctor(id);
    }
    public String deleteDoctor(int id){
        return doctorService.deleteDoctor(id);
    }

}
