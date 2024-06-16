package org.example.bank.service.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.bank.enums.CardType;
import org.example.bank.service.api.Account;
import org.example.bank.service.api.Card;
import org.example.utils.annotation.Validate;
import org.example.utils.repository.enums.ValidatorCase;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CardImpl implements Card {

    private Integer id;

    @Validate(validatorCase = ValidatorCase.IDENTIFICATION_NUMBER, message = "Nieprawidłowy numer karty.",
            maxTextLength = 16)
    private String cardNumber;

    private LocalDate expireDate;

    private String cvc;

    private CardType cardType;

    private Account account;

    public CardImpl(String cardNumber, LocalDate expireDate, String cvc, CardType cardType, Account account) {
        this.cardNumber = cardNumber;
        this.expireDate = expireDate;
        this.cvc = cvc;
        this.cardType = cardType;
        this.account = account;
    }
}
