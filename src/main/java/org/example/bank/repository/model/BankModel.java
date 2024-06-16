package org.example.bank.repository.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.utils.annotation.FieldCategory;
import org.example.utils.repository.model.AddressModel;
import org.example.utils.repository.model.BankAcc;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class BankModel extends BankAcc<Integer> {

    @FieldCategory(dbColumn = true)
    public final static String NAME = "name";

    @FieldCategory(dbColumn = true)
    public final static String ADDRESS_ID = "address_id";

    @FieldCategory(dbColumn = true)
    public final static String SWIFT = "swift";

    @FieldCategory(dbColumn = true)
    public final static String WEBSITE_URL = "website_url";

    @FieldCategory(dbColumn = true)
    public final static String NIP = "nip";

    @FieldCategory(dbColumn = true)
    public final static String KRS = "krs";

    @FieldCategory(dbColumn = true)
    public final static String REGON = "regon";

    private final static String TABLE_NAME = "bank";

    @FieldCategory(dbField = true)
    private String name;

    @FieldCategory(dbField = true, fetchField = true)
    private AddressModel address;

    @FieldCategory(dbField = true)
    private String swift;

    @FieldCategory(dbField = true)
    private String websiteUrl;

    @FieldCategory(dbField = true)
    private String nip;

    @FieldCategory(dbField = true)
    private String krs;

    @FieldCategory(dbField = true)
    private String regon;

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }
}
