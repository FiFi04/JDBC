package org.example.client.service.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.client.repository.enums.ClientType;
import org.example.client.service.api.Client;
import org.example.utils.service.api.Address;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class AbstractClient implements Client {

    private Integer id;

    private String name;

    private Address mainAddress;

    private Address correspondenceAddress;

    private String email;

    private ClientType clientType;
}
