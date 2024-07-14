package org.example.main.service.impl;

import org.example.main.enums.ModuleType;
import org.example.main.service.api.Factory;
import org.example.utils.exceptions.RepositoryException;
import org.example.utils.logger.Logger;
import org.example.utils.logger.LoggerImpl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

public class ModuleFactory implements Factory {

    private Logger logger = LoggerImpl.getInstance();

    @Override
    public Optional<Object> createModuleImpl(ModuleType moduleType) {
        String modulePath = moduleType.getPath();
        try {
            Class<?> classObject = Class.forName(modulePath);
            Constructor<?> constructor = classObject.getConstructor();
            return Optional.of(constructor.newInstance());
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException |
                 IllegalAccessException e) {
            RepositoryException exception = new RepositoryException("Błąd podczas tworzenia odpowiedniego modułu: " + e.getCause(), e);
            logger.logAnException(exception, exception.getMessage());
            throw exception;
        }
    }
}
