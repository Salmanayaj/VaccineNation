package com.example.VaccineNation.dto.request;

import com.example.VaccineNation.Enum.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PatientRequest {

    private String name;

    private int age;

    private Gender gender;

    private String emailid;
}
