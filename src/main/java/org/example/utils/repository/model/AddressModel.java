package org.example.utils.repository.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.utils.annotation.FieldCategory;
import org.example.utils.repository.enums.AddressType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class AddressModel extends BankAcc<Integer> {

    @FieldCategory(dbColumn = true)
    public final static String STREET = "street";

    @FieldCategory(dbColumn = true)
    public final static String HOUSE_NUMBER = "house_number";

    @FieldCategory(dbColumn = true)
    public final static String FLAT_NUMBER = "flat_number";

    @FieldCategory(dbColumn = true)
    public final static String ZIP_CODE = "zip_code";

    @FieldCategory(dbColumn = true)
    public final static String CITY = "city";

    @FieldCategory(dbColumn = true)
    public final static String ADDRESS_TYPE = "address_type";

    private final static String TABLE_NAME = "address";

    @FieldCategory(dbField = true)
    private String street;

    @FieldCategory(dbField = true)
    private String houseNumber;

    @FieldCategory(dbField = true)
    private String flatNumber;

    @FieldCategory(dbField = true)
    private String zipCode;

    @FieldCategory(dbField = true)
    private String city;

    @FieldCategory(dbField = true)
    private AddressType addressType;

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }
}