package org.example.client.service.impl;

import org.example.client.repository.model.IndividualClientModel;
import org.example.client.service.api.Client;
import org.example.utils.service.api.Address;
import org.example.utils.service.impl.AddressImpl;
import org.mapstruct.Mapper;
import org.mapstruct.ObjectFactory;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IndividualClientMapper {

    IndividualClientMapper INSTANCE = Mappers.getMapper(IndividualClientMapper.class);

    IndividualClientModel domainToClientModel(Client individualClientImpl);

    Client clientModelToDomain(IndividualClientModel individualClientModel);

    @ObjectFactory
    default Client createIndividualClient() {
        return new IndividualClientImpl();
    }

    @ObjectFactory
    default Address createAddress() {
        return new AddressImpl();
    }
}
