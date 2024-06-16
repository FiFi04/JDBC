package org.example.bank.service.api;

import java.time.LocalDate;

public interface CardService {

    void add (Card card);

    void close (Integer cardId);

    void extendValidity (Integer cardId, LocalDate newDate);
}
