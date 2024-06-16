package org.example.bank.service.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.bank.service.api.Bank;
import org.example.utils.annotation.Validate;
import org.example.utils.repository.enums.ValidatorCase;
import org.example.utils.service.api.Address;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class BankImpl implements Bank {

    private Integer id;

    private String name;

    private Address address;

    @Validate(validatorCase = ValidatorCase.TEXT, message = "Niepoprawny kod SWIFT",
            format = "^[a-zA-Z]+{6}[a-zA-Z0-9]+{2}[a-zA-Z0-9]+{0,3}$", maxTextLength = 11)
    private String swift;

    private String websiteUrl;

    @Validate(validatorCase = ValidatorCase.IDENTIFICATION_NUMBER, message = "Niepoprawny NIP",
            maxTextLength = 10)
    private String nip;

    @Validate(validatorCase = ValidatorCase.TEXT, message = "Niepoprawny numer KRS",
            maxTextLength = 10)
    private String krs;

    @Validate(validatorCase = ValidatorCase.IDENTIFICATION_NUMBER, message = "Niepoprawny REGON",
            maxTextLength = 9)
    private String regon;

    public BankImpl(String name, Address address, String swift, String websiteUrl, String nip, String krs, String regon) {
        this.name = name;
        this.address = address;
        this.swift = swift;
        this.websiteUrl = websiteUrl;
        this.nip = nip;
        this.krs = krs;
        this.regon = regon;
    }
}
