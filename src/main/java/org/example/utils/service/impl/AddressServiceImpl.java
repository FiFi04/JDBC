package org.example.utils.service.impl;

import org.example.utils.exceptions.ValidationException;
import org.example.utils.logger.Logger;
import org.example.utils.logger.LoggerImpl;
import org.example.utils.repository.AddressRepository;
import org.example.utils.repository.model.AddressModel;
import org.example.utils.service.api.Address;
import org.example.utils.service.api.AddressService;
import org.example.utils.service.api.ValidatorService;

import java.util.Map;
import java.util.Optional;

public class AddressServiceImpl implements AddressService {

    AddressRepository addressRepository = new AddressRepository();

    AddressMapper addressMapper = AddressMapper.INSTANCE;

    private ValidatorService validatorService = new ValidatorServiceImpl();

    private Logger logger = LoggerImpl.getInstance();

    private Map<String, String> constraints;

    @Override
    public void save(Address address) {
        constraints = validatorService.validateFields(address);
        if (constraints.isEmpty()) {
            AddressModel addressModel = addressMapper.domainToAddressModel(address);
            addressRepository.save(addressModel);
        } else {
            ValidationException exception = new ValidationException("Błędne dane podczas dodawania adresu: ", constraints);
            logger.logAnException(exception, exception.getMessage(), constraints);
            throw exception;
        }
    }

    @Override
    public Optional<Address> update(Address address) {
        constraints = validatorService.validateFields(address);
        if (constraints.isEmpty()) {
            AddressModel addressModel = addressMapper.domainToAddressModel(address);
            AddressModel updatedAddressModel = addressRepository.saveAndFlush(addressModel);
            return Optional.of(addressMapper.addressModelToDomain(updatedAddressModel));
        } else {
            ValidationException exception = new ValidationException("Błędne dane podczas aktualizowania adresu: ", constraints);
            logger.logAnException(exception, exception.getMessage(), constraints);
            throw exception;
        }
    }

    @Override
    public void delete(Address address) {
        AddressModel addressModel = addressMapper.domainToAddressModel(address);
        addressRepository.deleteById(addressModel.getId());
    }
}
