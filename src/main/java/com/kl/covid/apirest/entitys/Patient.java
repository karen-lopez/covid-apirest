package com.kl.covid.apirest.entitys;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="patients")
public class Patient implements Serializable {
    @Id
    @Column(name = "document_number")
    private Long documentNumber;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "date_birth")
    @Temporal(TemporalType.DATE)
    private Date dateBirth;

    public Long getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(Long documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }
}
