package org.example.client.service.impl;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.example.client.repository.enums.DocumentType;
import org.example.client.repository.enums.Sex;
import org.example.client.service.api.IndividualClient;
import org.example.utils.annotation.Validate;
import org.example.utils.repository.enums.ValidatorCase;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class IndividualClientImpl extends AbstractClient implements IndividualClient {

    private String firstName;

    private String middleName;

    @Validate(validatorCase = ValidatorCase.IDENTIFICATION_NUMBER, message = "Pesel nie jest poprawny",
            format = "\\d{11}", maxTextLength = 11)
    private String pesel;

    private LocalDate birthDate;

    private Sex sex;

    private DocumentType documentType;

    @Validate(validatorCase = ValidatorCase.DOCUMENT_NUMBER, message = "Numer dokumentu nie jest poprawny")
    private String documentNumber;
}
