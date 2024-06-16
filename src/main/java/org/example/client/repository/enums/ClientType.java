package org.example.client.repository.enums;

public enum ClientType {
    INDIVIDUAL,
    BUSINESS;

    public boolean isIndividual () {
        return this.equals(ClientType.INDIVIDUAL);
    }

    public boolean isBusiness () {
        return this.equals(ClientType.BUSINESS);
    }
}
