package com.codingshuttle.hospitalManagement.service;


import com.codingshuttle.hospitalManagement.entity.Insurance;
import com.codingshuttle.hospitalManagement.entity.Patient;
import com.codingshuttle.hospitalManagement.repository.InsuranceRepository;
import com.codingshuttle.hospitalManagement.repository.PatientRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InsuranceService {

//    Here we should use the final becaue at above we use the construction injection
    private final  InsuranceRepository insuranceRepository;
    private final PatientRepo patientReposiotry;

//    first step assign insurance to patient
    @Transactional
    public Patient   assignInsuranceToPatient(Insurance insurance , Long patientId){

        Patient patient = patientReposiotry.findById(patientId).orElseThrow(()->new EntityNotFoundException("Patient of this is not found"));

        patient.setInsurance(insurance);  // It is dirty checking where if there is any change then it will reflects in the datbase without calling save method

        insurance.setPatient(patient); //
        return patient ;

    }
//    Remove patient from the insurance if patient does not want insurance
    

    @Transactional
    public Patient disaccociationInsuranceFromPatient(Long patientId){
        Patient patient=patientReposiotry.findById(patientId).orElseThrow(()->new RuntimeException("Patient not found "+patientId));

        patient.setInsurance(null);
        return patient;

    }
}
