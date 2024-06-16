package org.example.utils.service.impl;

import org.example.utils.repository.model.AddressModel;
import org.example.utils.service.api.Address;
import org.mapstruct.Mapper;
import org.mapstruct.ObjectFactory;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    AddressModel domainToAddressModel(Address address);

    Address addressModelToDomain(AddressModel addressModel);

    @ObjectFactory
    default Address createAddress() {
        return new AddressImpl();
    }
}
