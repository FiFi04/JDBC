package org.example.utils.repository.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.utils.annotation.FieldCategory;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class BankAcc<E> {

    @FieldCategory(dbColumn = true)
    public final static String ID = "id";

    @FieldCategory(dbField = true)
    protected E id;

    public abstract String getTableName();
}
