package org.example.bank.service.impl;

import org.example.bank.repository.model.CardModel;
import org.example.bank.service.api.Account;
import org.example.bank.service.api.Card;
import org.mapstruct.Mapper;
import org.mapstruct.ObjectFactory;
import org.mapstruct.factory.Mappers;

@Mapper(uses = BankMapper.class)
public interface CardMapper {

    CardMapper INSTANCE = Mappers.getMapper(CardMapper.class);

    CardModel domainToCardModel(Card card);

    Card cardModelToDomain(CardModel cardModel);

    @ObjectFactory
    default Card createCard() {
        return new CardImpl();
    }

    @ObjectFactory
    default Account createAccount() {
        return new AccountImpl();
    }
}
