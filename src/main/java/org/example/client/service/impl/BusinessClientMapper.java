package org.example.client.service.impl;

import org.example.client.repository.model.BusinessClientModel;
import org.example.client.service.api.Client;
import org.example.utils.service.api.Address;
import org.example.utils.service.impl.AddressImpl;
import org.mapstruct.Mapper;
import org.mapstruct.ObjectFactory;
import org.mapstruct.SubclassMapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BusinessClientMapper {

    BusinessClientMapper INSTANCE = Mappers.getMapper(BusinessClientMapper.class);

    @SubclassMapping(source = BusinessClientImpl.class, target = BusinessClientModel.class)
    BusinessClientModel domainToClientModel(Client businessClientImpl);

    @SubclassMapping(source = BusinessClientModel.class, target = BusinessClientImpl.class)
    Client clientModelToDomain(BusinessClientModel businessClientModel);

    @ObjectFactory
    default Client createBusinessClient() {
        return new BusinessClientImpl();
    }

    @ObjectFactory
    default Address createAddress() {
        return new AddressImpl();
    }
}
