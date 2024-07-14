package org.example.bank.repository;

import org.example.bank.repository.model.AccountModel;
import org.example.utils.repository.BankAccRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository extends BankAccRepository<AccountModel, Integer> {

    private final String tableName = "client_account";

    public boolean addOwner(Integer accountId, Integer ownerId) {
        if (accountId == null || ownerId == null) {
            return false;
        }
        Connection connection = dbConnector.getConnection();
        String query = "INSERT INTO %s (account_id, client_id) VALUES (%s, %s)";
        try (Statement statement = connection.createStatement()) {
            String completeQuery = String.format(query, tableName, accountId, ownerId);
            logger.log(completeQuery);
            statement.executeUpdate(completeQuery);
            return true;
        } catch (SQLException e) {
            logAndThrowException("Błąd podczas dodawania współzałożyciela konta: " + e.getMessage(), e);
        }
        return false;
    }

    public void deleteAssignedOwner(Integer accountId) {
        Connection connection = dbConnector.getConnection();
        String selectQuery = "SELECT * FROM %s WHERE %s = %s";
        String deleteQuery = "DELETE FROM %s WHERE id IN (%s)";
        try {
            Statement statement = connection.createStatement();
            String completeSelectQuery = String.format(selectQuery, tableName, "account_id", accountId);
            logger.log(completeSelectQuery);
            ResultSet resultSet = statement.executeQuery(completeSelectQuery);
            List<Integer> client_accountIdToDelete = new ArrayList<>();
            while (resultSet.next()) {
                client_accountIdToDelete.add(resultSet.getInt("id"));
            }
            if (client_accountIdToDelete.isEmpty()) {
                return;
            }
            String completeDeleteQuery = String.format(deleteQuery, tableName,
                    client_accountIdToDelete.toString().replace("[", "").replace("]", ""));
            logger.log(completeDeleteQuery);
            statement.executeUpdate(completeDeleteQuery);
        } catch (SQLException e) {
            logAndThrowException("Błąd usuwania powiązanych właścicieli kont: " + e.getMessage(), e);
        }
    }
}
