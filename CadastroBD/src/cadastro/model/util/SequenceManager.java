package cadastro.model.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SequenceManager {
    public static int getValue(String sequenceName) {
        int nextValue = 0;
        String sql = "SELECT NEXT VALUE FOR " + sequenceName + " AS nextval";
        try (Connection connection = ConectorBD.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                nextValue = resultSet.getInt("nextval");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nextValue;
    }
}
