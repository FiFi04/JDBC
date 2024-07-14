package org.example.client.service.impl;

import javax.annotation.processing.Generated;
import org.example.client.repository.model.BusinessClientModel;
import org.example.client.service.api.Client;
import org.example.utils.repository.model.AddressModel;
import org.example.utils.service.api.Address;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-17T19:46:30+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
public class BusinessClientMapperImpl implements BusinessClientMapper {

    @Override
    public BusinessClientModel domainToClientModel(Client businessClientImpl) {
        if ( businessClientImpl == null ) {
            return null;
        }

        if (businessClientImpl instanceof BusinessClientImpl) {
            return businessClientImplToBusinessClientModel( (BusinessClientImpl) businessClientImpl );
        }
        else {
            BusinessClientModel.BusinessClientModelBuilder<?, ?> businessClientModel = BusinessClientModel.builder();

            businessClientModel.id( businessClientImpl.getId() );
            businessClientModel.name( businessClientImpl.getName() );
            businessClientModel.mainAddress( addressToAddressModel( businessClientImpl.getMainAddress() ) );
            businessClientModel.correspondenceAddress( addressToAddressModel( businessClientImpl.getCorrespondenceAddress() ) );
            businessClientModel.email( businessClientImpl.getEmail() );
            businessClientModel.clientType( businessClientImpl.getClientType() );
            businessClientModel.nip( businessClientImpl.getNip() );
            businessClientModel.regon( businessClientImpl.getRegon() );

            return businessClientModel.build();
        }
    }

    @Override
    public Client clientModelToDomain(BusinessClientModel businessClientModel) {
        if ( businessClientModel == null ) {
            return null;
        }

        if (businessClientModel instanceof BusinessClientModel) {
            return businessClientModelToBusinessClientImpl( (BusinessClientModel) businessClientModel );
        }
        else {
            Client client = createBusinessClient();

            client.setId( businessClientModel.getId() );
            client.setName( businessClientModel.getName() );
            client.setMainAddress( addressModelToAddress( businessClientModel.getMainAddress() ) );
            client.setCorrespondenceAddress( addressModelToAddress( businessClientModel.getCorrespondenceAddress() ) );
            client.setEmail( businessClientModel.getEmail() );
            client.setClientType( businessClientModel.getClientType() );
            client.setNip( businessClientModel.getNip() );
            client.setRegon( businessClientModel.getRegon() );

            return client;
        }
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

    protected BusinessClientModel businessClientImplToBusinessClientModel(BusinessClientImpl businessClientImpl) {
        if ( businessClientImpl == null ) {
            return null;
        }

        BusinessClientModel.BusinessClientModelBuilder<?, ?> businessClientModel = BusinessClientModel.builder();

        businessClientModel.id( businessClientImpl.getId() );
        businessClientModel.name( businessClientImpl.getName() );
        businessClientModel.mainAddress( addressToAddressModel( businessClientImpl.getMainAddress() ) );
        businessClientModel.correspondenceAddress( addressToAddressModel( businessClientImpl.getCorrespondenceAddress() ) );
        businessClientModel.email( businessClientImpl.getEmail() );
        businessClientModel.clientType( businessClientImpl.getClientType() );
        businessClientModel.nip( businessClientImpl.getNip() );
        businessClientModel.regon( businessClientImpl.getRegon() );

        return businessClientModel.build();
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

    protected BusinessClientImpl businessClientModelToBusinessClientImpl(BusinessClientModel businessClientModel) {
        if ( businessClientModel == null ) {
            return null;
        }

        BusinessClientImpl.BusinessClientImplBuilder<?, ?> businessClientImpl = BusinessClientImpl.builder();

        businessClientImpl.id( businessClientModel.getId() );
        businessClientImpl.name( businessClientModel.getName() );
        businessClientImpl.mainAddress( addressModelToAddress( businessClientModel.getMainAddress() ) );
        businessClientImpl.correspondenceAddress( addressModelToAddress( businessClientModel.getCorrespondenceAddress() ) );
        businessClientImpl.email( businessClientModel.getEmail() );
        businessClientImpl.clientType( businessClientModel.getClientType() );
        businessClientImpl.nip( businessClientModel.getNip() );
        businessClientImpl.regon( businessClientModel.getRegon() );

        return businessClientImpl.build();
    }
}
