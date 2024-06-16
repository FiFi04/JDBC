package org.example.main.service.api;

import org.example.main.enums.ModuleType;

public interface Factory {

    Object createModuleImpl(ModuleType moduleType);
}
