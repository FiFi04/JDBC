package org.example.bank.service.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.bank.enums.AccountType;
import org.example.bank.service.api.Account;
import org.example.bank.service.api.Bank;
import org.example.utils.annotation.Validate;
import org.example.utils.repository.enums.ValidatorCase;
import org.example.utils.service.impl.TextValidator;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class AccountImpl implements Account {

    private Integer id;

    @Validate(validatorCase = ValidatorCase.TEXT, message = "Niepoprawny numer konta", format = TextValidator.NUMBERS_REGEX,
            maxTextLength = 26)
    private String accountNumber;

    private BigDecimal balance;

    private AccountType accountType;

    private Bank bank;

    private List<Integer> ownersId;

    public AccountImpl(String accountNumber, BigDecimal balance, AccountType accountType, Bank bank) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
        this.bank = bank;
    }
}
