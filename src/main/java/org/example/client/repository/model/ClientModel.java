package org.example.client.repository.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.utils.annotation.FieldCategory;
import org.example.utils.repository.model.AddressModel;
import org.example.client.repository.enums.ClientType;
import org.example.utils.repository.model.BankAcc;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class ClientModel extends BankAcc<Integer> {

    @FieldCategory(dbColumn = true)
    public final static String FIRST_NAME = "first_name";

    @FieldCategory(dbColumn = true)
    public final static String MIDDLE_NAME = "middle_name";

    @FieldCategory(dbColumn = true)
    public final static String NAME = "name";

    @FieldCategory(dbColumn = true)
    public final static String EMAIL = "email";

    @FieldCategory(dbColumn = true)
    public final static String PESEL = "pesel";

    @FieldCategory(dbColumn = true)
    public final static String BIRTH_DATE = "birth_date";

    @FieldCategory(dbColumn = true)
    public final static String SEX = "sex";

    @FieldCategory(dbColumn = true)
    public final static String DOCUMENT_TYPE = "document_type";

    @FieldCategory(dbColumn = true)
    public final static String DOCUMENT_NUMBER = "document_number";

    @FieldCategory(dbColumn = true)
    public final static String NIP = "nip";

    @FieldCategory(dbColumn = true)
    public final static String REGON = "regon";

    @FieldCategory(dbColumn = true)
    public final static String MAIN_ADDRESS_ID = "main_address_id";

    @FieldCategory(dbColumn = true)
    public final static String CORRESPONDENCE_ADDRESS_ID = "correspondence_address_id";

    @FieldCategory(dbColumn = true)
    public final static String CLIENT_TYPE = "client_type";

    private final static String TABLE_NAME = "client";

    @FieldCategory(dbField = true)
    protected String name;

    @FieldCategory(dbField = true, fetchField = true)
    protected AddressModel mainAddress;

    @FieldCategory(dbField = true, fetchField = true)
    protected AddressModel correspondenceAddress;

    @FieldCategory(dbField = true)
    protected String email;

    @FieldCategory(dbField = true)
    protected ClientType clientType;

    public ClientModel(int id, String name, AddressModel mainAddress, AddressModel correspondenceAddress, String email, ClientType clientType) {
        super(id);
        this.name = name;
        this.mainAddress = mainAddress;
        this.correspondenceAddress = correspondenceAddress;
        this.email = email;
        this.clientType = clientType;
    }

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }
}
