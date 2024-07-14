package org.example.bank.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.example.bank.repository.model.AccountModel;
import org.example.bank.repository.model.CardModel;
import org.example.bank.service.api.Account;
import org.example.bank.service.api.Card;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-17T19:46:30+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
public class CardMapperImpl implements CardMapper {

    private final BankMapper bankMapper = BankMapper.INSTANCE;

    @Override
    public CardModel domainToCardModel(Card card) {
        if ( card == null ) {
            return null;
        }

        CardModel.CardModelBuilder<?, ?> cardModel = CardModel.builder();

        cardModel.id( card.getId() );
        cardModel.cardNumber( card.getCardNumber() );
        cardModel.expireDate( card.getExpireDate() );
        cardModel.cvc( card.getCvc() );
        cardModel.cardType( card.getCardType() );
        cardModel.account( accountToAccountModel( card.getAccount() ) );

        return cardModel.build();
    }

    @Override
    public Card cardModelToDomain(CardModel cardModel) {
        if ( cardModel == null ) {
            return null;
        }

        Card card = createCard();

        card.setId( cardModel.getId() );
        card.setCardNumber( cardModel.getCardNumber() );
        card.setExpireDate( cardModel.getExpireDate() );
        card.setCvc( cardModel.getCvc() );
        card.setCardType( cardModel.getCardType() );
        card.setAccount( accountModelToAccount( cardModel.getAccount() ) );

        return card;
    }

    protected AccountModel accountToAccountModel(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountModel.AccountModelBuilder<?, ?> accountModel = AccountModel.builder();

        accountModel.id( account.getId() );
        List<Integer> list = account.getOwnersId();
        if ( list != null ) {
            accountModel.ownersId( new ArrayList<Integer>( list ) );
        }
        accountModel.accountNumber( account.getAccountNumber() );
        accountModel.balance( account.getBalance() );
        accountModel.accountType( account.getAccountType() );
        accountModel.bank( bankMapper.domainToBankModel( account.getBank() ) );

        return accountModel.build();
    }

    protected Account accountModelToAccount(AccountModel accountModel) {
        if ( accountModel == null ) {
            return null;
        }

        Account account = createAccount();

        account.setId( accountModel.getId() );
        account.setAccountNumber( accountModel.getAccountNumber() );
        account.setBalance( accountModel.getBalance() );
        account.setAccountType( accountModel.getAccountType() );
        account.setBank( bankMapper.bankModelToDomain( accountModel.getBank() ) );
        List<Integer> list = accountModel.getOwnersId();
        if ( list != null ) {
            account.setOwnersId( new ArrayList<Integer>( list ) );
        }

        return account;
    }
}
