package org.example.utils.service.api;

import java.lang.reflect.Field;

public interface Validator {

    boolean valid(String value, Field field);
}
