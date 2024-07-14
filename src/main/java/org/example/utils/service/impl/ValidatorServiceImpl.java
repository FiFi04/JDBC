package org.example.utils.service.impl;

import org.example.utils.annotation.Validate;
import org.example.utils.exceptions.ValidationException;
import org.example.utils.logger.Logger;
import org.example.utils.logger.LoggerImpl;
import org.example.utils.repository.enums.ValidatorCase;
import org.example.utils.service.api.ValidatorService;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class ValidatorServiceImpl implements ValidatorService {

    public static final Map<ValidatorCase, String> classNameResolver = new HashMap<>();

    private Logger logger = LoggerImpl.getInstance();

    static {
        classNameResolver.put(ValidatorCase.TEXT, "org.example.utils.service.impl.TextValidator");
        classNameResolver.put(ValidatorCase.IDENTIFICATION_NUMBER, "org.example.utils.service.impl.IdentificationNumberValidator");
        classNameResolver.put(ValidatorCase.DOCUMENT_NUMBER, "org.example.utils.service.impl.DocumentNumberValidator");
    }

    public Map<String, String> validateFields(Object object) {
        Map<String, String> constraints = new HashMap<>();
        Class<?> objectClass = object.getClass();
        Field[] classFields = objectClass.getDeclaredFields();
        Field[] superclassFields = objectClass.getSuperclass().getDeclaredFields();
        Field[] allFields = Stream
                .concat(Arrays.stream(classFields), Arrays.stream(superclassFields))
                .toArray(Field[]::new);
        Arrays.stream(allFields)
                .filter(field -> field.isAnnotationPresent(Validate.class))
                .forEach(field -> {
                    field.setAccessible(true);
                    try {
                        boolean isValid = isValid(object, field);
                        if (!isValid) {
                            constraints.put(field.getName(), field.getAnnotation(Validate.class).message());
                        }

                    } catch (IllegalAccessException | ClassNotFoundException | InvocationTargetException |
                             InstantiationException | NoSuchMethodException e) {
                        ValidationException exception = new ValidationException("Błąd podczas walidacji: " + e.getMessage(), e);
                        logger.logAnException(exception, exception.getMessage());
                        throw exception;
                    }
                });
        return constraints;
    }

    @Override
    public Map<String, String> validateWithInnerFields(Object object) {
        Map<String, String> constraints = validateFields(object);
        Field[] declaredFields = object.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getType().getName().startsWith("org.example") && !field.getType().isEnum()) {
                field.setAccessible(true);
                try {
                    constraints.putAll(validateWithInnerFields(field.get(object)));
                } catch (IllegalAccessException e) {
                    ValidationException exception = new ValidationException("Błąd podczas walidacji: " + e.getMessage(), e);
                    logger.logAnException(exception, exception.getMessage());
                    throw exception;
                }
            }
        }
        return constraints;
    }

    private boolean isValid(Object object, Field field) throws IllegalAccessException, ClassNotFoundException,
            InstantiationException, InvocationTargetException, NoSuchMethodException {
        Object fieldValue = field.get(object);
        ValidatorCase validatorCase = field.getAnnotation(Validate.class).validatorCase();
        Class<?> cls = Class.forName(classNameResolver.get(validatorCase));
        Constructor<?> clsConstructor = cls.getConstructors()[0];
        Object clsObject = clsConstructor.newInstance();
        Method validMethod = clsObject.getClass().getMethod("valid", String.class, Field.class);
        return (boolean) validMethod.invoke(clsObject, fieldValue.toString(), field);
    }
}
