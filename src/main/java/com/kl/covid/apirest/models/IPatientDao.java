package com.kl.covid.apirest.models;

import com.kl.covid.apirest.entitys.Patient;
import org.springframework.data.repository.CrudRepository;

public interface IPatientDao extends CrudRepository<Patient, Long> {

}
