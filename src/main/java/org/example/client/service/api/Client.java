package org.example.client.service.api;

import org.example.client.repository.enums.ClientType;
import org.example.client.repository.enums.DocumentType;
import org.example.client.repository.enums.Sex;
import org.example.utils.service.api.Address;

import java.time.LocalDate;

public interface Client {

    Integer getId();

    void setId(Integer id);

    String getName();

    void setName(String name);

    Address getMainAddress();

    void setMainAddress(Address mainAddress);

    Address getCorrespondenceAddress();

    void setCorrespondenceAddress(Address correspondenceAddress);

    String getEmail();

    void setEmail(String email);

    ClientType getClientType();

    void setClientType(ClientType clientType);

    default String getNip() {
        return null;
    }

    default void setNip(String nip) {
    }

    default String getRegon() {
        return null;
    }

    default void setRegon(String regon) {
    }

    default String getFirstName() {
        return null;
    }

    default void setFirstName(String firstName) {
    }

    default String getMiddleName() {
        return null;
    }

    default void setMiddleName(String middleName) {
    }

    default String getPesel() {
        return null;
    }

    default void setPesel(String pesel) {
    }

    default LocalDate getBirthDate() {
        return null;
    }

    default void setBirthDate(LocalDate birthDate) {
    }

    default Sex getSex() {
        return null;
    }

    default void setSex(Sex sex) {
    }

    default DocumentType getDocumentType() {
        return null;
    }

    default void setDocumentType(DocumentType documentType) {
    }

    default String getDocumentNumber() {
        return null;
    }

    default void setDocumentNumber(String documentNumber) {
    }
}
