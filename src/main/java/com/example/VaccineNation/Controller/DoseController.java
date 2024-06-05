package com.example.VaccineNation.Controller;

import com.example.VaccineNation.Enum.VaccineBrand;
import com.example.VaccineNation.Model.Dose;
import com.example.VaccineNation.Service.DoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Dose")
public class DoseController {

    @Autowired
    DoseService doseService;

    @PostMapping("/vaccinated")
    public Dose addDose(@RequestParam("id") int patientid,
                        @RequestParam("brand") VaccineBrand vaccinebrand){
        return doseService.addDose(patientid, vaccinebrand);
    }

    /* work to do
    1. Make Entity Relationship
    2. Make doctor API's
    3. Make api to vaccinate people
     */
}
