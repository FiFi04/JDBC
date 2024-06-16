package org.example.client.service.impl;

import org.example.client.repository.BusinessClientRepository;
import org.example.client.repository.IndividualClientRepository;
import org.example.client.repository.enums.ClientType;
import org.example.client.repository.model.BusinessClientModel;
import org.example.client.repository.model.IndividualClientModel;
import org.example.client.service.api.Client;
import org.example.client.service.api.ClientService;
import org.example.utils.exceptions.RepositoryException;
import org.example.utils.exceptions.ValidationException;
import org.example.utils.logger.Logger;
import org.example.utils.logger.LoggerImpl;
import org.example.utils.service.api.ValidatorService;
import org.example.utils.service.impl.ValidatorServiceImpl;

import java.util.Map;
import java.util.Optional;

public class ClientServiceImpl implements ClientService {

    BusinessClientRepository businessClientRepository = new BusinessClientRepository();

    IndividualClientRepository individualClientRepository = new IndividualClientRepository();

    BusinessClientMapper businessClientMapper = BusinessClientMapper.INSTANCE;

    IndividualClientMapper individualClientMapper = IndividualClientMapper.INSTANCE;

    private ValidatorService validatorService = new ValidatorServiceImpl();

    private Logger logger = LoggerImpl.getInstance();

    private Map<String, String> constraints;

    @Override
    public Optional<Client> add(Client client) {
        try {
            constraints = validatorService.validateWithInnerFields(client);
            if (!constraints.isEmpty()) {
                logger.log("Błędne dane podczas dodawania klienta: ", constraints);
                return Optional.empty();
            }
            ClientType clientType = client.getClientType();
            if (clientType.isIndividual()) {
                IndividualClientModel individualClientModel = individualClientMapper.domainToClientModel(client);
                IndividualClientModel addedClientModel = individualClientRepository.saveAndFlush(individualClientModel);
                Client addedClient = individualClientMapper.clientModelToDomain(addedClientModel);
                return Optional.of(addedClient);
            } else {
                BusinessClientModel businessClientModel = businessClientMapper.domainToClientModel(client);
                BusinessClientModel addedClientModel = businessClientRepository.saveAndFlush(businessClientModel);
                Client addedClient = businessClientMapper.clientModelToDomain(addedClientModel);
                return Optional.of(addedClient);
            }
        } catch (RepositoryException | ValidationException exception) {
            logger.logAnException(exception, exception.getMessage(), constraints);
            throw exception;
        }
    }

    @Override
    public Optional<Client> update(Client client) {
        try {
            Integer id = client.getId();
            if (individualClientRepository.findById(id).isEmpty()) {
                return Optional.empty();
            }
            constraints = validatorService.validateWithInnerFields(client);
            if (!constraints.isEmpty()) {
                logger.log("Błędne dane podczas aktualizowania klienta: ", constraints);
                return Optional.empty();
            }
            if (client.getClientType().isIndividual()) {
                IndividualClientModel individualClientModel = individualClientMapper.domainToClientModel(client);
                IndividualClientModel updatedClientModel = individualClientRepository.saveAndFlush(individualClientModel);
                Client updatedClient = individualClientMapper.clientModelToDomain(updatedClientModel);
                return Optional.of(updatedClient);
            } else {
                BusinessClientModel businessClientModel = businessClientMapper.domainToClientModel(client);
                BusinessClientModel updatedClientModel = businessClientRepository.saveAndFlush(businessClientModel);
                Client updatedClient = businessClientMapper.clientModelToDomain(updatedClientModel);
                return Optional.of(updatedClient);
            }
        } catch (RepositoryException | ValidationException exception) {
            logger.logAnException(exception, exception.getMessage(), constraints);
            throw exception;
        }
    }

    @Override
    public void deleteById(Integer id) {
        try {
            individualClientRepository.deleteById(id);
        } catch (RepositoryException exception) {
            logger.logAnException(exception, exception.getMessage());
            throw exception;
        }
    }
}