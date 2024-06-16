package org.example.client.service.impl;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.example.client.service.api.BusinessClient;
import org.example.utils.annotation.Validate;
import org.example.utils.repository.enums.ValidatorCase;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class BusinessClientImpl extends AbstractClient implements BusinessClient {

    @Validate(validatorCase = ValidatorCase.IDENTIFICATION_NUMBER, message = "NIP jest niepoprawny",
            maxTextLength = 10)
    private String nip;

    @Validate(validatorCase = ValidatorCase.IDENTIFICATION_NUMBER, message = "Regon jest niepoprawny",
            maxTextLength = 9)
    private String regon;
}
