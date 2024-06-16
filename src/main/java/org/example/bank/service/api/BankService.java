package org.example.bank.service.api;

public interface BankService {

    void add (Bank bank);

    Bank update (Bank bank);

    void delete (Integer bankId);
}
