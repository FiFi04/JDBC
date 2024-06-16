package org.example.bank.service.impl;

import org.example.bank.repository.BankRepository;
import org.example.bank.repository.model.BankModel;
import org.example.bank.service.api.Bank;
import org.example.bank.service.api.BankService;
import org.example.utils.exceptions.RepositoryException;
import org.example.utils.exceptions.ValidationException;
import org.example.utils.logger.Logger;
import org.example.utils.logger.LoggerImpl;
import org.example.utils.service.api.ValidatorService;
import org.example.utils.service.impl.ValidatorServiceImpl;

import java.util.Map;

public class BankServiceImpl implements BankService {

    BankRepository bankRepository = new BankRepository();

    BankMapper bankMapper = BankMapper.INSTANCE;

    private ValidatorService validatorService = new ValidatorServiceImpl();

    private Logger logger = LoggerImpl.getInstance();

    private Map<String, String> constraints;

    @Override
    public void add(Bank bank) {
        try {
            constraints = validatorService.validateWithInnerFields(bank);
            if (constraints.isEmpty()) {
                BankModel bankModel = bankMapper.domainToBankModel(bank);
                bankRepository.save(bankModel);
            } else {
                logger.log("Błędne dane podczas dodawania banku: ", constraints);
            }
        } catch (RepositoryException | ValidationException exception) {
            logger.logAnException(exception, exception.getMessage(), constraints);
            throw exception;
        }
    }

    @Override
    public Bank update(Bank bank) {
        try {
            constraints = validatorService.validateWithInnerFields(bank);
            if (constraints.isEmpty()) {
                BankModel bankModel = bankMapper.domainToBankModel(bank);
                BankModel updatedBankModel = bankRepository.saveAndFlush(bankModel);
                return bankMapper.bankModelToDomain(updatedBankModel);
            } else {
                logger.log("Błędne dane podczas aktualizowania banku: ", constraints);
                return bank;
            }
        } catch (RepositoryException | ValidationException exception) {
            logger.logAnException(exception, exception.getMessage(), constraints);
            throw exception;
        }
    }

    @Override
    public void delete(Integer bankId) {
        try {
            bankRepository.deleteById(bankId);
        } catch (RepositoryException exception) {
            logger.logAnException(exception, exception.getMessage());
            throw exception;
        }
    }
}
