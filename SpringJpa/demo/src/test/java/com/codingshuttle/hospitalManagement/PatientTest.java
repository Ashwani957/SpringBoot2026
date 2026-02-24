package com.codingshuttle.hospitalManagement;

import com.codingshuttle.hospitalManagement.entity.Patient;
import com.codingshuttle.hospitalManagement.repository.PatientRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;
import java.util.List;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@SpringBootTest
public class PatientTest {

@Autowired
private PatientRepo patientRepo;



//springboot testing are done Herew
@Test
    public void testPatientRepository(){
 List <Patient> patientList=patientRepo.findAll();

 System.out.println(patientList);
}
// thisi test will be comment about because it print the uncessary Hiberante logs that cause problems
//
//@Test
//    public void testRepo(){
//    Patient patientList=patientRepo.findByName("Ankita Sharma");
//    List<Patient> patientListDetails=patientRepo.findByBirthDateOrEmail(LocalDate.of(2002,8,26),"aman.verma@gmail.com");
//    List<Patient> gender = patientRepo.findByGender("Male");
//    List<Patient> birthDate=patientRepo.findByBirthDate(LocalDate.of(2000,2,8));
//    List<Object[]> genderCount=patientRepo.filterByGender();
//    List<Patient> listOfPatient= patientRepo.findAllPatient();
//    int updateNameWithId=patientRepo.updateNameWithId("Anjali Sharma",2L);
////    for pagination concept we will use it
//    Page<Patient> ListOfPatientsPagination= patientRepo.findAllPatients(PageRequest.of(1,2));
//
//    System.out.println(patientList);
////    for(Patient patient: patientListDetails){
////        System.out.println(patient);
////    }
////    patientListDetails.forEach((patient)->System.out.println(patient));
//    patientListDetails.forEach(System.out::println);
//    System.out.println("GenderData");
//    gender.forEach(System.out::println);
////    birthdate
//    System.out.println("BirthDate");
//    birthDate.forEach((b)->System.out.println(b));
//
////
//    for(Object[] objects : genderCount){
//        System.out.println(objects[0] + "" + objects[1]);
//    }
//
//    System.out.println("List of Patient");
//
//   listOfPatient.forEach(System.out::println);
//
//   System.out.println(updateNameWithId);
//
//   System.out.println("Data Fecting After Pagination ");
//
//    ListOfPatientsPagination.forEach((p)->System.out.println(p));
//
//}





}
