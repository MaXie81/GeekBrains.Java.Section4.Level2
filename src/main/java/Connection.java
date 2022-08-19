import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connection {
    private final String DRIVER = "org.h2.Driver";
    private final String URL = "jdbc:h2:file:C:\\DB\\DBH2.Cinema";
    private String username = "user";
    private String password = "user";

    private final String sql_drop_table_films = "DROP TABLE TAB_FILMS IF EXISTS";
    private final String sql_drop_table_time = "DROP TABLE TAB_DIC_TIME IF EXISTS";
    private final String sql_drop_table_day = "DROP TABLE TAB_DIC_DAY IF EXISTS";
    private final String sql_drop_table_sessions = "DROP TABLE TAB_SESSIONS IF EXISTS";
    private final String sql_drop_table_tickets = "DROP TABLE TAB_TICKETS IF EXISTS";

    private final String sql_create_table_films =
            "CREATE TABLE TAB_FILMS("
            + "ID_FILM BIGSERIAL PRIMARY KEY,"
            + "NAME VARCHAR2(255 CHAR),"
            + "DURATION BIGINT,"
            + "PRICE DECIMAL(15, 2)"
            + ")";
    private final String sql_create_table_time =
            "CREATE TABLE TAB_DIC_TIME("
            + "ID_TIME INT PRIMARY KEY,"
            + "FLG_TIME VARCHAR2(1 CHAR)"
            + ")";
    private final String sql_create_table_day =
            "CREATE TABLE TAB_DIC_DAY("
            + "ID_DAY VARCHAR2(3 CHAR) PRIMARY KEY,"
            + "FLG_DAY VARCHAR2(1 CHAR)"
            + ")";
    private final String sql_create_table_sessions =
            "CREATE TABLE TAB_SESSIONS("
            + "ID_SESSION BIGSERIAL PRIMARY KEY,"
            + "ID_FILM BIGINT REFERENCES TAB_FILMS(ID_FILM),"
            + "ID_DAY BIGINT REFERENCES TAB_DIC_DAY(ID_DAY),"
            + "ID_TIME BIGINT REFERENCES TAB_DIC_TIME(ID_TIME)"
            + ")";
    private final String sql_create_table_tickets =
            "CREATE TABLE TAB_TICKETS("
            + "ID_TICKET BIGSERIAL PRIMARY KEY,"
            + "ID_FILM BIGINT REFERENCES TAB_FILMS(ID_FILM),"
            + "ID_SESSION BIGINT REFERENCES TAB_SESSIONS(ID_SESSION)"
            + ")";

    private final String sql_select_count_films = "SELECT COUNT(*) AS CNT FROM PUBLIC.TAB_FILMS";

    private java.sql.Connection connection;
    private Statement sqlQuery;
    private ResultSet dataQuery;

    public void open() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, username, password);
            connection.setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void init() {
        try {
            sqlQuery = connection.createStatement();

            sqlQuery.execute(sql_drop_table_tickets);
            sqlQuery.execute(sql_drop_table_sessions);
            sqlQuery.execute(sql_drop_table_day);
            sqlQuery.execute(sql_drop_table_time);
            sqlQuery.execute(sql_drop_table_films);

            sqlQuery.execute(sql_create_table_films);
            sqlQuery.execute(sql_create_table_time);
            sqlQuery.execute(sql_create_table_day);
            sqlQuery.execute(sql_create_table_sessions);
            sqlQuery.execute(sql_create_table_tickets);

//            dataQuery = sqlQuery.executeQuery(sql_select_count_films);
        } catch (SQLException exception) {
            System.out.println("???");
            exception.printStackTrace();
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
