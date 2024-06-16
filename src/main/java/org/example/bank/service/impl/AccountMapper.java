package org.example.bank.service.impl;

import org.example.bank.repository.model.AccountModel;
import org.example.bank.service.api.Account;
import org.example.bank.service.api.Bank;
import org.example.utils.service.impl.AddressMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ObjectFactory;
import org.mapstruct.factory.Mappers;

@Mapper(uses = AddressMapper.class)
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    AccountModel domainToAccountModel(Account accountImpl);

    Account accountModelToDomain(AccountModel accountModel);

    @ObjectFactory
    default Account createAccount() {
        return new AccountImpl();
    }

    @ObjectFactory
    default Bank createBank() {
        return new BankImpl();
    }
}
