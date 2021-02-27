package com.kl.covid.apirest.services;

import com.kl.covid.apirest.entitys.Patient;

import java.util.List;

public interface IPatientService {
    List<Patient> findAll();
    Patient findById(Long documentNumber);
    Patient save(Patient patient);
}
