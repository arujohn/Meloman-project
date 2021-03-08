import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQL implements IDB {

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String databaseURL = "jdbc:postgresql://localhost:5432/meloman";

        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(databaseURL, "postgres", "0000");
        return connection;
    }
}
