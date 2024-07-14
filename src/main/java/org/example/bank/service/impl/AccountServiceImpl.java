package org.example.bank.service.impl;

import org.example.bank.repository.AccountRepository;
import org.example.bank.repository.model.AccountModel;
import org.example.bank.service.api.Account;

import org.example.bank.service.api.AccountService;
import org.example.client.service.api.Client;
import org.example.client.service.api.ClientService;
import org.example.main.enums.ModuleType;
import org.example.main.service.api.Factory;
import org.example.main.service.impl.ModuleFactory;
import org.example.utils.exceptions.ValidationException;
import org.example.utils.logger.Logger;
import org.example.utils.logger.LoggerImpl;
import org.example.utils.service.api.ValidatorService;
import org.example.utils.service.impl.ValidatorServiceImpl;

import java.util.Map;
import java.util.Optional;

public class AccountServiceImpl implements AccountService {

    AccountRepository accountRepository = new AccountRepository();

    AccountMapper accountMapper = AccountMapper.INSTANCE;

    private ValidatorService validatorService = new ValidatorServiceImpl();

    private Logger logger = LoggerImpl.getInstance();

    private Map<String, String> constraints;

    @Override
    public void open(Account account) {
        constraints = validatorService.validateWithInnerFields(account);
        if (constraints.isEmpty()) {
            AccountModel accountModel = accountMapper.domainToAccountModel(account);
            AccountModel newAccount = accountRepository.saveAndFlush(accountModel);
            if (account.getOwnersId() != null) {
                for (Integer ownerId : account.getOwnersId()) {
                    accountRepository.addOwner(newAccount.getId(), ownerId);
                }
            }
        } else {
            ValidationException exception = new ValidationException("Błędne dane podczas dodawania konta: ", constraints);
            logger.logAnException(exception, exception.getMessage(), constraints);
            throw exception;
        }
    }

    @Override
    public void close(Integer accountId) {
        accountRepository.deleteAssignedOwner(accountId);
        accountRepository.deleteById(accountId);
    }

    @Override
    public void addOwner(Integer accountId, Client client) {
        Optional<AccountModel> accountById = accountRepository.findById(accountId);
        Integer clientId = client.getId();
        if (clientId == null && accountById.isPresent()) {
            Optional<Client> addedClient = null;
            Factory clientModuleFactory = new ModuleFactory();
            Optional<ClientService> clientService = (Optional<ClientService>) clientModuleFactory.createModuleImpl(ModuleType.CLIENT);
            if (clientService.isPresent()) {
                addedClient = clientService.get().add(client);
            }
            if (addedClient.isPresent()) {
                accountRepository.addOwner(accountId, addedClient.get().getId());
                logger.log("Dodano klienta i współwłaściciela");
            }
        } else if (clientId != null && accountById.isPresent()) {
            accountRepository.addOwner(accountId, clientId);
            logger.log("Dodano współwłaściciela");
        } else {
            logger.log("Brak konta dla klienta o podanym numerze ID: {}", accountId);
        }
    }
}
