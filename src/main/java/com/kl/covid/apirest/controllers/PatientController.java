package com.kl.covid.apirest.controllers;

import com.kl.covid.apirest.entitys.Patient;
import com.kl.covid.apirest.services.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class PatientController {

    @Autowired
    IPatientService patientService;

    @GetMapping("/patients")
    public List<Patient> list(){
        return patientService.findAll();
    }

    @PostMapping("/patients")
    public Patient create(@RequestBody Patient patient, HttpServletResponse response){
        LocalDate date = patient.getDateBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate today = LocalDate.now();
        int age = today.getYear() - date.getYear();
        Period period = Period.between(date, today);
        if(period.getYears() >= 18){
            if(patientService.findById(patient.getDocumentNumber()) == null) return patientService.save(patient);
        }
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return new Patient();
    }
}
