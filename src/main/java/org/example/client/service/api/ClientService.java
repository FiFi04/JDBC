package org.example.client.service.api;

import java.util.Optional;

public interface ClientService {

    Optional<Client> add(Client client);

    Optional<Client> update(Client client);

    void deleteById(Integer id);
}
