package org.example.utils.service.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.utils.annotation.Validate;
import org.example.utils.repository.enums.AddressType;
import org.example.utils.repository.enums.ValidatorCase;
import org.example.utils.service.api.Address;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class AddressImpl implements Address {

    private Integer id;

    @Validate(validatorCase = ValidatorCase.TEXT, message = TextValidator.ADDRESS_MESSAGE,
            format = TextValidator.TEXT_REGEX, maxTextLength = 45)
    private String street;

    @Validate(validatorCase = ValidatorCase.TEXT, message = TextValidator.ADDRESS_MESSAGE, maxTextLength = 10)
    private String houseNumber;

    @Validate(validatorCase = ValidatorCase.TEXT, message = TextValidator.ADDRESS_MESSAGE, maxTextLength = 10)
    private String flatNumber;

    @Validate(validatorCase = ValidatorCase.TEXT, message = "Niepoprawny format kodu pocztowego",
            format = "\\d{2}-\\d{3}")
    private String zipCode;

    @Validate(validatorCase = ValidatorCase.TEXT, message = "Niepoprawny format wpisanej nazwy miasta",
            format = TextValidator.TEXT_REGEX, maxTextLength = 45)
    private String city;

    private AddressType addressType;

    public AddressImpl(String street, String houseNumber, String flatNumber, String zipCode, String city, AddressType addressType) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.flatNumber = flatNumber;
        this.zipCode = zipCode;
        this.city = city;
        this.addressType = addressType;
    }
}
