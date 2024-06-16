package org.example.bank.service.api;

import org.example.utils.service.api.Address;

public interface Bank {

    Integer getId();

    void setId(Integer id);

    String getName();

    void setName(String name);

    Address getAddress();

    void setAddress(Address address);

    String getSwift();

    void setSwift(String swift);

    String getWebsiteUrl();

    void setWebsiteUrl(String websiteUrl);

    String getNip();

    void setNip(String nip);

    String getKrs();

    void setKrs(String krs);

    String getRegon();

    void setRegon(String regon);
}
