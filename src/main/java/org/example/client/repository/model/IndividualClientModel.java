package org.example.client.repository.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.utils.annotation.FieldCategory;
import org.example.utils.repository.model.AddressModel;
import org.example.client.repository.enums.ClientType;
import org.example.client.repository.enums.DocumentType;
import org.example.client.repository.enums.Sex;
import org.example.client.utils.PeselUtils;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class IndividualClientModel extends ClientModel {

    @FieldCategory(dbField = true)
    private String firstName;

    @FieldCategory(dbField = true)
    private String middleName;

    @FieldCategory(dbField = true)
    private String pesel;

    @FieldCategory(dbField = true)
    private LocalDate birthDate;

    @FieldCategory(dbField = true)
    private Sex sex;

    @FieldCategory(dbField = true)
    private DocumentType documentType;

    @FieldCategory(dbField = true)
    private String documentNumber;

    public IndividualClientModel(int id, String firstName, String middleName, String lastName, String personalIDNumber,
                                 DocumentType documentType, String documentNumber, AddressModel mainAddress,
                                 AddressModel correspondenceAddress, String email, ClientType clientType) {
        super(id, lastName, mainAddress, correspondenceAddress, email, clientType);
        this.firstName = firstName;
        this.middleName = middleName;
        this.pesel = personalIDNumber;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.birthDate = PeselUtils.setBirthdate(personalIDNumber);
        this.sex = PeselUtils.setPersonSex(personalIDNumber);
    }

    @Override
    public String toString() {
        return "IndividualClientModel{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", pesel='" + pesel + '\'' +
                ", birthDate=" + birthDate +
                ", sex=" + sex +
                ", documentType=" + documentType +
                ", documentNumber='" + documentNumber + '\'' +
                ", name='" + name + '\'' +
                ", mainAddress=" + mainAddress +
                ", correspondenceAddress=" + correspondenceAddress +
                ", email='" + email + '\'' +
                ", clientType=" + clientType +
                ", id=" + id +
                '}';
    }
}
