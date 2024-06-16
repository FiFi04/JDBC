package org.example.bank.repository.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.utils.annotation.FieldCategory;
import org.example.bank.enums.CardType;
import org.example.utils.repository.model.BankAcc;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class CardModel extends BankAcc<Integer> {

    @FieldCategory(dbColumn = true)
    public final static String CARD_NUMBER = "card_number";

    @FieldCategory(dbColumn = true)
    public final static String EXPIRE_DATE = "expire_date";

    @FieldCategory(dbColumn = true)
    public final static String CVC = "cvc";

    @FieldCategory(dbColumn = true)
    public final static String CARD_TYPE = "card_type";

    @FieldCategory(dbColumn = true)
    public final static String ACCOUNT_ID = "account_id";

    private final static String TABLE_NAME = "card";

    @FieldCategory(dbField = true)
    private String cardNumber;

    @FieldCategory(dbField = true)
    private LocalDate expireDate;

    @FieldCategory(dbField = true)
    private String cvc;

    @FieldCategory(dbField = true)
    private CardType cardType;

    @FieldCategory(dbField = true, fetchField = true)
    private AccountModel account;

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }
}
