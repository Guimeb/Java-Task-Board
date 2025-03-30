package br.com.dio.persistence.config;

import lombok.NoArgsConstructor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class ConnectionConfig {

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("H2 driver not found", e);
        }
        // Usando H2 em memória com compatibilidade para comandos MySQL (MODE=MySQL)
        var url = "jdbc:h2:mem:board;DB_CLOSE_DELAY=-1;MODE=MySQL";
        var user = "sa";
        var password = "";
        var connection = DriverManager.getConnection(url, user, password);
        connection.setAutoCommit(false);
        return connection;
    }
}
