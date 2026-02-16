package com.codingshuttle.hospitalManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.lang.annotation.Around;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PatientDetails  {
    private String name;
    private String gender;
    private LocalDate localDate;
}
