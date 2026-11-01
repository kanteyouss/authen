package com.authentification.authentification.connectionBd;

import java.sql.Connection;
import java.sql.SQLException;

public interface DatabaseConnectionServiceInterface {
    Connection getConnection() throws SQLException;
    boolean testConnection();
}
