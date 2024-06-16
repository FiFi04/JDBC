package org.example.main.enums;

public enum ModuleType {
    ACCOUNT("org.example.bank.service.impl.AccountServiceImpl"),
    BANK("org.example.bank.service.impl.BankServiceImpl"),
    CARD("org.example.bank.service.impl.CardServiceImpl"),
    CLIENT("org.example.client.service.impl.ClientServiceImpl"),
    ADDRESS("org.example.utils.service.impl.AddressServiceImpl");

    private final String path;

    ModuleType(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
