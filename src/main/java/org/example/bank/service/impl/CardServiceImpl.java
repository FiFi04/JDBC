package org.example.bank.service.impl;

import org.example.bank.repository.CardRepository;
import org.example.bank.repository.model.CardModel;
import org.example.bank.service.api.Card;
import org.example.bank.service.api.CardService;
import org.example.utils.exceptions.RepositoryException;
import org.example.utils.exceptions.ValidationException;
import org.example.utils.logger.Logger;
import org.example.utils.logger.LoggerImpl;
import org.example.utils.service.api.ValidatorService;
import org.example.utils.service.impl.ValidatorServiceImpl;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

public class CardServiceImpl implements CardService {

    CardRepository cardRepository = new CardRepository();

    CardMapper cardMapper = CardMapper.INSTANCE;

    private ValidatorService validatorService = new ValidatorServiceImpl();

    private Logger logger = LoggerImpl.getInstance();

    private Map<String, String> constraints;

    @Override
    public void add(Card card) {
        try {
            constraints = validatorService.validateWithInnerFields(card);
            if (constraints.isEmpty()) {
                CardModel cardModel = cardMapper.domainToCardModel(card);
                cardRepository.save(cardModel);
            } else {
                throw new ValidationException("Błędne dane podczas dodawania karty: ", constraints);
            }
        } catch (RepositoryException | ValidationException exception) {
            logger.logAnException(exception, exception.getMessage(), constraints);
            throw exception;
        }
    }

    @Override
    public void close(Integer cardId) {
        try {
            cardRepository.deleteById(cardId);
        } catch (RepositoryException exception) {
            logger.logAnException(exception, exception.getMessage());
            throw exception;
        }
    }

    @Override
    public void extendValidity(Integer cardId, LocalDate newDate) {
        try {
            Optional<CardModel> card = cardRepository.findFetchById(cardId);
            if (card.isPresent()) {
                card.get().setExpireDate(newDate);
                cardRepository.save(card.get());
            } else {
                logger.log("Brak karty o podanym numerze ID: {}", cardId);
            }
        } catch (RepositoryException exception) {
            logger.logAnException(exception, exception.getMessage());
            throw exception;
        }
    }
}
