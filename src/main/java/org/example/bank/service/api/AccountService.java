package org.example.bank.service.api;

import org.example.client.service.api.Client;

public interface AccountService {

    void open (Account account);

    void close (Integer accountId);

    void addOwner(Integer accountId, Client owner);
}
