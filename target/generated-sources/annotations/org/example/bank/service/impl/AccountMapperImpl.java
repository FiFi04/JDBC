package org.example.bank.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.example.bank.repository.model.AccountModel;
import org.example.bank.repository.model.BankModel;
import org.example.bank.service.api.Account;
import org.example.bank.service.api.Bank;
import org.example.utils.service.impl.AddressMapper;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-17T19:46:30+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
public class AccountMapperImpl implements AccountMapper {

    private final AddressMapper addressMapper = AddressMapper.INSTANCE;

    @Override
    public AccountModel domainToAccountModel(Account accountImpl) {
        if ( accountImpl == null ) {
            return null;
        }

        AccountModel.AccountModelBuilder<?, ?> accountModel = AccountModel.builder();

        accountModel.id( accountImpl.getId() );
        List<Integer> list = accountImpl.getOwnersId();
        if ( list != null ) {
            accountModel.ownersId( new ArrayList<Integer>( list ) );
        }
        accountModel.accountNumber( accountImpl.getAccountNumber() );
        accountModel.balance( accountImpl.getBalance() );
        accountModel.accountType( accountImpl.getAccountType() );
        accountModel.bank( bankToBankModel( accountImpl.getBank() ) );

        return accountModel.build();
    }

    @Override
    public Account accountModelToDomain(AccountModel accountModel) {
        if ( accountModel == null ) {
            return null;
        }

        Account account = createAccount();

        account.setId( accountModel.getId() );
        account.setAccountNumber( accountModel.getAccountNumber() );
        account.setBalance( accountModel.getBalance() );
        account.setAccountType( accountModel.getAccountType() );
        account.setBank( bankModelToBank( accountModel.getBank() ) );
        List<Integer> list = accountModel.getOwnersId();
        if ( list != null ) {
            account.setOwnersId( new ArrayList<Integer>( list ) );
        }

        return account;
    }

    protected BankModel bankToBankModel(Bank bank) {
        if ( bank == null ) {
            return null;
        }

        BankModel.BankModelBuilder<?, ?> bankModel = BankModel.builder();

        bankModel.id( bank.getId() );
        bankModel.name( bank.getName() );
        bankModel.address( addressMapper.domainToAddressModel( bank.getAddress() ) );
        bankModel.swift( bank.getSwift() );
        bankModel.websiteUrl( bank.getWebsiteUrl() );
        bankModel.nip( bank.getNip() );
        bankModel.krs( bank.getKrs() );
        bankModel.regon( bank.getRegon() );

        return bankModel.build();
    }

    protected Bank bankModelToBank(BankModel bankModel) {
        if ( bankModel == null ) {
            return null;
        }

        Bank bank = createBank();

        bank.setId( bankModel.getId() );
        bank.setName( bankModel.getName() );
        bank.setAddress( addressMapper.addressModelToDomain( bankModel.getAddress() ) );
        bank.setSwift( bankModel.getSwift() );
        bank.setWebsiteUrl( bankModel.getWebsiteUrl() );
        bank.setNip( bankModel.getNip() );
        bank.setKrs( bankModel.getKrs() );
        bank.setRegon( bankModel.getRegon() );

        return bank;
    }
}
