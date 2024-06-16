package org.example.client.service.api;

import org.example.client.repository.enums.DocumentType;
import org.example.client.repository.enums.Sex;

import java.time.LocalDate;

public interface IndividualClient extends Client {

    String getFirstName();

    void setFirstName(String firstName);

    String getMiddleName();

    void setMiddleName(String middleName);

    String getPesel();

    void setPesel(String pesel);

    LocalDate getBirthDate();

    void setBirthDate(LocalDate birthDate);

    Sex getSex();

    void setSex(Sex sex);

    DocumentType getDocumentType();

    void setDocumentType(DocumentType documentType);

    String getDocumentNumber();

    void setDocumentNumber(String documentNumber);
}
