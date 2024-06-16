package org.example.bank.service.impl;

import javax.annotation.processing.Generated;
import org.example.bank.repository.model.BankModel;
import org.example.bank.service.api.Bank;
import org.example.utils.repository.model.AddressModel;
import org.example.utils.service.api.Address;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-26T21:51:33+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
public class BankMapperImpl implements BankMapper {

    @Override
    public BankModel domainToBankModel(Bank bank) {
        if ( bank == null ) {
            return null;
        }

        if (bank instanceof BankImpl) {
            return bankImplToBankModel( (BankImpl) bank );
        }
        else {
            BankModel.BankModelBuilder<?, ?> bankModel = BankModel.builder();

            bankModel.id( bank.getId() );
            bankModel.name( bank.getName() );
            bankModel.address( addressToAddressModel( bank.getAddress() ) );
            bankModel.swift( bank.getSwift() );
            bankModel.websiteUrl( bank.getWebsiteUrl() );
            bankModel.nip( bank.getNip() );
            bankModel.krs( bank.getKrs() );
            bankModel.regon( bank.getRegon() );

            return bankModel.build();
        }
    }

    @Override
    public Bank bankModelToDomain(BankModel bankModel) {
        if ( bankModel == null ) {
            return null;
        }

        if (bankModel instanceof BankModel) {
            return bankModelToBankImpl( (BankModel) bankModel );
        }
        else {
            Bank bank = createBank();

            bank.setId( bankModel.getId() );
            bank.setName( bankModel.getName() );
            bank.setAddress( addressModelToAddress( bankModel.getAddress() ) );
            bank.setSwift( bankModel.getSwift() );
            bank.setWebsiteUrl( bankModel.getWebsiteUrl() );
            bank.setNip( bankModel.getNip() );
            bank.setKrs( bankModel.getKrs() );
            bank.setRegon( bankModel.getRegon() );

            return bank;
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

    protected BankModel bankImplToBankModel(BankImpl bankImpl) {
        if ( bankImpl == null ) {
            return null;
        }

        BankModel.BankModelBuilder<?, ?> bankModel = BankModel.builder();

        bankModel.id( bankImpl.getId() );
        bankModel.name( bankImpl.getName() );
        bankModel.address( addressToAddressModel( bankImpl.getAddress() ) );
        bankModel.swift( bankImpl.getSwift() );
        bankModel.websiteUrl( bankImpl.getWebsiteUrl() );
        bankModel.nip( bankImpl.getNip() );
        bankModel.krs( bankImpl.getKrs() );
        bankModel.regon( bankImpl.getRegon() );

        return bankModel.build();
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

    protected BankImpl bankModelToBankImpl(BankModel bankModel) {
        if ( bankModel == null ) {
            return null;
        }

        BankImpl.BankImplBuilder<?, ?> bankImpl = BankImpl.builder();

        bankImpl.id( bankModel.getId() );
        bankImpl.name( bankModel.getName() );
        bankImpl.address( addressModelToAddress( bankModel.getAddress() ) );
        bankImpl.swift( bankModel.getSwift() );
        bankImpl.websiteUrl( bankModel.getWebsiteUrl() );
        bankImpl.nip( bankModel.getNip() );
        bankImpl.krs( bankModel.getKrs() );
        bankImpl.regon( bankModel.getRegon() );

        return bankImpl.build();
    }
}
