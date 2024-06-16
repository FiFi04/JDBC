package org.example.utils.service.impl;

import javax.annotation.processing.Generated;
import org.example.utils.repository.model.AddressModel;
import org.example.utils.service.api.Address;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-26T21:51:33+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
public class AddressMapperImpl implements AddressMapper {

    @Override
    public AddressModel domainToAddressModel(Address address) {
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

    @Override
    public Address addressModelToDomain(AddressModel addressModel) {
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
