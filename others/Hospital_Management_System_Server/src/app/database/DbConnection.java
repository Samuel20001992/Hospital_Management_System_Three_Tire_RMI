package app.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static app.database.DatabaseInfo.*;

public class DbConnection {

    private static Connection connection;

    private DbConnection() {}

    public static Connection getConnection() {
        if(connection == null) {
            try{
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(
                        dbUrl,
                        username,
                        password
                );
            }
            catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
        return connection;
    }
}
