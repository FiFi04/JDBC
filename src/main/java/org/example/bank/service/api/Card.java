package org.example.bank.service.api;

import org.example.bank.enums.CardType;

import java.time.LocalDate;

public interface Card {

    Integer getId();

    void setId(Integer id);

    String getCardNumber();

    void setCardNumber(String cardNumber);

    LocalDate getExpireDate();

    void setExpireDate(LocalDate expireDate);

    String getCvc();

    void setCvc(String cvc);

    CardType getCardType();

    void setCardType(CardType cardType);

    Account getAccount();

    void setAccount(Account account);
}
