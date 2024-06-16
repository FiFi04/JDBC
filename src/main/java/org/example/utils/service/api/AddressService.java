package org.example.utils.service.api;

import java.util.Optional;

public interface AddressService {

    void save(Address address);

    Optional<Address> update(Address address);

    void delete(Address address);
}
