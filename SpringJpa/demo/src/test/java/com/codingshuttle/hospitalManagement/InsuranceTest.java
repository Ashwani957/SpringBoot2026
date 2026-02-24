package com.codingshuttle.hospitalManagement;

import com.codingshuttle.hospitalManagement.entity.Appointment;
import com.codingshuttle.hospitalManagement.entity.Insurance;
import com.codingshuttle.hospitalManagement.entity.Patient;
import com.codingshuttle.hospitalManagement.service.AppointmentService;
import com.codingshuttle.hospitalManagement.service.InsuranceService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
@RequiredArgsConstructor
public class InsuranceTest {


    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private AppointmentService appointmentService;


    @Test
    public void testInsurance(){

        Insurance insurance =Insurance.builder().policyNumber("HDFC!@#").provider("HDFC").validUnit(LocalDate.of(2023,12,12)).build();
        Patient patient= insuranceService.assignInsuranceToPatient(insurance,1L);
        System.out.println(patient);
        var newPatient=insuranceService.disaccociationInsuranceFromPatient(patient.getId());
       System.out.println("newPatient"+newPatient);

    }

    @Test
    public void testCreateAppointment(){
        Appointment appointment =Appointment.builder().appointmentTime(LocalDateTime.of(2026,2,2,14,2,1))
                .reason("cough").build();

        var newAppointment=appointmentService.createNewAppointment(appointment,2L,1L);
        System.out.println(newAppointment);

        var UpdatedAppointment=appointmentService.reAssignAppointmentToAnotherDoctor(newAppointment.getId(),1L);
        System.out.println(UpdatedAppointment);
    }


}
