package org.example.bank.repository.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.utils.annotation.FieldCategory;
import org.example.bank.enums.AccountType;
import org.example.utils.repository.model.BankAcc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class AccountModel extends BankAcc<Integer> {

    @FieldCategory(dbColumn = true)
    public final static String ACCOUNT_NUMBER = "account_number";

    @FieldCategory(dbColumn = true)
    public final static String BALANCE = "balance";

    @FieldCategory(dbColumn = true)
    public final static String ACCOUNT_TYPE = "account_type";

    @FieldCategory(dbColumn = true)
    public final static String BANK_ID = "bank_id";

    private final static String TABLE_NAME = "account";

    private List<Integer> ownersId = new ArrayList<>();

    @FieldCategory(dbField = true)
    private String accountNumber;

    @FieldCategory(dbField = true)
    private BigDecimal balance;

    @FieldCategory(dbField = true)
    private AccountType accountType;

    @FieldCategory(dbField = true, fetchField = true)
    private BankModel bank;

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }
}
