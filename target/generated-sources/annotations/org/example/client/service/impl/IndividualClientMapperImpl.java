package org.example.client.service.impl;

import javax.annotation.processing.Generated;
import org.example.client.repository.model.IndividualClientModel;
import org.example.client.service.api.Client;
import org.example.utils.repository.model.AddressModel;
import org.example.utils.service.api.Address;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-17T19:46:30+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
public class IndividualClientMapperImpl implements IndividualClientMapper {

    @Override
    public IndividualClientModel domainToClientModel(Client individualClientImpl) {
        if ( individualClientImpl == null ) {
            return null;
        }

        IndividualClientModel.IndividualClientModelBuilder<?, ?> individualClientModel = IndividualClientModel.builder();

        individualClientModel.id( individualClientImpl.getId() );
        individualClientModel.name( individualClientImpl.getName() );
        individualClientModel.mainAddress( addressToAddressModel( individualClientImpl.getMainAddress() ) );
        individualClientModel.correspondenceAddress( addressToAddressModel( individualClientImpl.getCorrespondenceAddress() ) );
        individualClientModel.email( individualClientImpl.getEmail() );
        individualClientModel.clientType( individualClientImpl.getClientType() );
        individualClientModel.firstName( individualClientImpl.getFirstName() );
        individualClientModel.middleName( individualClientImpl.getMiddleName() );
        individualClientModel.pesel( individualClientImpl.getPesel() );
        individualClientModel.birthDate( individualClientImpl.getBirthDate() );
        individualClientModel.sex( individualClientImpl.getSex() );
        individualClientModel.documentType( individualClientImpl.getDocumentType() );
        individualClientModel.documentNumber( individualClientImpl.getDocumentNumber() );

        return individualClientModel.build();
    }

    @Override
    public Client clientModelToDomain(IndividualClientModel individualClientModel) {
        if ( individualClientModel == null ) {
            return null;
        }

        Client client = createIndividualClient();

        client.setId( individualClientModel.getId() );
        client.setName( individualClientModel.getName() );
        client.setMainAddress( addressModelToAddress( individualClientModel.getMainAddress() ) );
        client.setCorrespondenceAddress( addressModelToAddress( individualClientModel.getCorrespondenceAddress() ) );
        client.setEmail( individualClientModel.getEmail() );
        client.setClientType( individualClientModel.getClientType() );
        client.setFirstName( individualClientModel.getFirstName() );
        client.setMiddleName( individualClientModel.getMiddleName() );
        client.setPesel( individualClientModel.getPesel() );
        client.setBirthDate( individualClientModel.getBirthDate() );
        client.setSex( individualClientModel.getSex() );
        client.setDocumentType( individualClientModel.getDocumentType() );
        client.setDocumentNumber( individualClientModel.getDocumentNumber() );

        return client;
    }

    protected AddressModel addressToAddressModel(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressModel.AddressModelBuilder<?, ?> addressModel = AddressModel.builder();

        addressModel.id( address.getId() );
        addressModel.street( address.getStreet() );
        addressModel.houseNumber( address.getHouseNumber() );
        addressModel.flatNumber( address.getFlatNumber() );
        addressModel.zipCode( address.getZipCode() );
        addressModel.city( address.getCity() );
        addressModel.addressType( address.getAddressType() );

        return addressModel.build();
    }

    protected Address addressModelToAddress(AddressModel addressModel) {
        if ( addressModel == null ) {
            return null;
        }

        Address address = createAddress();

        address.setId( addressModel.getId() );
        address.setStreet( addressModel.getStreet() );
        address.setHouseNumber( addressModel.getHouseNumber() );
        address.setFlatNumber( addressModel.getFlatNumber() );
        address.setZipCode( addressModel.getZipCode() );
        address.setCity( addressModel.getCity() );
        address.setAddressType( addressModel.getAddressType() );

        return address;
    }
}
