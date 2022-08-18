import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    private final String DRIVER = "org.h2.Driver";
    private final String URL = "jdbc:h2:file:C:\\DB\\DBH2.Cinema.mv.db";
    String username = "user";
    String password = "user";

    private java.sql.Connection connection;

    public void open() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, username, password);
            connection.setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
