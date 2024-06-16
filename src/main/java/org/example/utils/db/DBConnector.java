package org.example.utils.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnector {

    private static DBConnector dbConnector;

    private Connection connection;

    private DBConnector() {
        this.connection = initializeConnection();
    }

    public Connection getConnection() {
        return connection;
    }

    public static DBConnector getInstance() {
        if (dbConnector == null) {
            dbConnector = new DBConnector();
        }
        return dbConnector;
    }

    private Connection initializeConnection() {
        try {
            Properties properties = getProperties();
            String url = properties.getProperty("jdbc.url");
            String username = properties.getProperty("jdbc.username");
            String password = properties.getProperty("jdbc.password");
            connection = DriverManager.getConnection(url, username, password);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    private static Properties getProperties() throws IOException {
        Properties properties = new Properties();
        try (InputStream inputStream = DBConnector.class.getClassLoader().getResourceAsStream("db.properties")) {
            properties.load(inputStream);
        }
        return properties;
    }
}
