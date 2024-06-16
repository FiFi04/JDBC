package org.example.bank.service.api;

import org.example.bank.enums.AccountType;

import java.math.BigDecimal;
import java.util.List;

public interface Account {

    Integer getId();

    void setId(Integer id);

    String getAccountNumber();

    void setAccountNumber(String accountNumber);

    BigDecimal getBalance();

    void setBalance(BigDecimal balance);

    AccountType getAccountType();

    void setAccountType(AccountType accountType);

    Bank getBank();

    void setBank(Bank bank);

    List<Integer> getOwnersId();

    void setOwnersId(List<Integer> ownersId);
}
