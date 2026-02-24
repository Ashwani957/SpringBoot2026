package com.codingshuttle.hospitalManagement.service;

import com.codingshuttle.hospitalManagement.entity.Appointment;
import com.codingshuttle.hospitalManagement.entity.Doctor;
import com.codingshuttle.hospitalManagement.entity.Patient;
import com.codingshuttle.hospitalManagement.repository.AppointmentRepository;
import com.codingshuttle.hospitalManagement.repository.DoctorRepository;
import com.codingshuttle.hospitalManagement.repository.PatientRepo;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor

public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepo patientRepo;

    @Transactional
    public Appointment createNewAppointment(Appointment appointment, Long doctorId, Long patientId){
         Doctor doctor=doctorRepository.findById(doctorId).orElseThrow();
         Patient patient =patientRepo.findById(patientId).orElseThrow();

//    check
        if(appointment.getId() !=null ) throw new IllegalArgumentException("Appoinment should not have");

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

//        to maintain the bidirectional consistency we should use this
        patient.getAppointments().add(appointment);


        return     appointmentRepository.save(appointment);
    }

//    Assign patient to another doctors

    public Appointment reAssignAppointmentToAnotherDoctor(Long doctorId,Long appointmentId){
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
       Appointment appointment= appointmentRepository.findById(appointmentId).orElseThrow();

       appointment.setDoctor(doctor); // this will automatically call the update because it is dirty know
       return appointment;
    }
}
