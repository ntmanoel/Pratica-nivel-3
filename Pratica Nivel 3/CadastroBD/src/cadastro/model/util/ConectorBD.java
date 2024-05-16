package cadastro.model.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConectorBD {
    // Configurações de acesso ao banco de dados SQL Server
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=loja;encrypt=true;trustServerCertificate=true;";
    private static final String USUARIO = "loja";
    private static final String SENHA = "loja";

    // Método para obter uma conexão com o banco de dados
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }

    // Método para criar um objeto PreparedStatement a partir de uma consulta SQL
    public static PreparedStatement getPrepared(String sql) throws SQLException {
        return getConnection().prepareStatement(sql);
    }

    // Método para executar uma consulta SQL e retornar o ResultSet resultante
    public static ResultSet getSelect(String sql) throws SQLException {
        Statement statement = getConnection().createStatement();
        return statement.executeQuery(sql);
    }

    // Métodos para fechar recursos relacionados ao banco de dados
    public static void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
