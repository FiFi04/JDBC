package org.example.client.service.api;

public interface BusinessClient extends Client {

    String getNip();

    void setNip(String nip);

    String getRegon();

    void setRegon(String regon);
}
