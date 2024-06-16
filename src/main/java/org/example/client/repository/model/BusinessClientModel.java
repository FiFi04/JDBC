package org.example.client.repository.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.utils.annotation.FieldCategory;
import org.example.utils.repository.model.AddressModel;
import org.example.client.repository.enums.ClientType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class BusinessClientModel extends ClientModel {

    @FieldCategory(dbField = true)
    private String nip;

    @FieldCategory(dbField = true)
    private String regon;

    public BusinessClientModel(String name, AddressModel mainAddress, AddressModel correspondenceAddress, String email,
                               ClientType clientType, String nip, String regon) {
        super(name, mainAddress, correspondenceAddress, email, clientType);
        this.nip = nip;
        this.regon = regon;
    }

    @Override
    public String toString() {
        return "BusinessClientModel{" +
                "nip='" + nip + '\'' +
                ", regon='" + regon + '\'' +
                ", name='" + name + '\'' +
                ", mainAddress=" + mainAddress +
                ", correspondenceAddress=" + correspondenceAddress +
                ", email='" + email + '\'' +
                ", clientType=" + clientType +
                ", id=" + id +
                '}';
    }
}
