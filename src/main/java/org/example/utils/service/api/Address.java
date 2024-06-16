package org.example.utils.service.api;

import org.example.utils.repository.enums.AddressType;

public interface Address {

    Integer getId();

    void setId(Integer id);

    String getStreet();

    void setStreet(String street);

    String getHouseNumber();

    void setHouseNumber(String houseNumber);

    String getFlatNumber();

    void setFlatNumber(String flatNumber);

    String getZipCode();

    void setZipCode(String zipCode);

    String getCity();

    void setCity(String city);

    AddressType getAddressType();

    void setAddressType(AddressType addressType);
}
