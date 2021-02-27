package com.kl.covid.apirest.services;

import com.kl.covid.apirest.entitys.Patient;
import com.kl.covid.apirest.models.IPatientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PatientService implements IPatientService{

    @Autowired
    IPatientDao patientDao;

    @Override
    @Transactional(readOnly = true)
    public List<Patient> findAll() {
        return (List<Patient>) patientDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Patient findById(Long documentNumber) {
        return patientDao.findById(documentNumber).orElse(null);
    }

    @Override
    @Transactional
    public Patient save(Patient patient) {
        return patientDao.save(patient);
    }
}
