package org.example.bank.service.impl;

import org.example.bank.repository.model.BankModel;
import org.example.bank.service.api.Bank;
import org.example.utils.service.api.Address;
import org.example.utils.service.impl.AddressImpl;
import org.mapstruct.Mapper;
import org.mapstruct.ObjectFactory;
import org.mapstruct.SubclassMapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BankMapper {

    BankMapper INSTANCE = Mappers.getMapper(BankMapper.class);

    @SubclassMapping(source = BankImpl.class, target = BankModel.class)
    BankModel domainToBankModel(Bank bank);

    @SubclassMapping(source = BankModel.class, target = BankImpl.class)
    Bank bankModelToDomain(BankModel bankModel);

    @ObjectFactory
    default Bank createBank() {
        return new BankImpl();
    }

    @ObjectFactory
    default Address createAddress() {
        return new AddressImpl();
    }
}
