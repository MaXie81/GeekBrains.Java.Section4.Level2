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
            + "ID_DAY VARCHAR2(3 CHAR) REFERENCES TAB_DIC_DAY(ID_DAY),"
            + "ID_TIME BIGINT REFERENCES TAB_DIC_TIME(ID_TIME)"
            + ")";
    private final String sql_create_table_tickets =
            "CREATE TABLE TAB_TICKETS("
            + "ID_TICKET BIGSERIAL PRIMARY KEY,"
            + "ID_SESSION BIGINT REFERENCES TAB_SESSIONS(ID_SESSION),"
            + "ID_SEAT SMALLINT"
            + ")";

    private final String sql_insert_times = "INSERT INTO TAB_DIC_TIME VALUES"
            + "(0, 0), (1, 0), (2, 0), (3, 0), (4, 0), (5, 0), (6, 0), (7, 0),"
            + "(23, 1), (8, 1), (9, 1), (10, 1), (11, 1), (12, 1), (13, 1), (14, 1), (15, 1), (16, 1),"
            + "(17, 2), (18, 2), (19, 2), (20, 2), (21, 2), (22, 2)";
    private final String sql_insert_days = "INSERT INTO TAB_DIC_DAY VALUES"
            + "('ПНД', 0), ('ВТР', 0), ('СРД', 0), ('ЧТВ', 0), ('ПТН', 0), ('СБТ', 1), ('ВСК', 1)";
    private final String sql_insert_films = "INSERT INTO TAB_FILMS VALUES"
            + "(1, 'Матрица', 150, 450.00),"
            + "(2, 'Терминатор', 120, 400.00),"
            + "(3, 'Аватар', 180, 550.00),"
            + "(4, 'Пятый элемент', 90, 300.00)";
    private final String sql_insert_sessions = "INSERT INTO TAB_SESSIONS(ID_FILM, ID_DAY, ID_TIME) VALUES"
            + "(4, 'СРД', 0), (4, 'СРД', 3), (2, 'СРД', 4), (1, 'СРД', 6), (3, 'СРД', 10),"
            + "(1, 'СРД', 12), (2, 'СРД', 15), (3, 'СРД', 17), (1, 'СРД', 21)";
    private final String sql_insert_tickets = "INSERT INTO TAB_TICKETS(ID_SESSION, ID_SEAT) VALUES"
            + "(3, 10), (6, 31), (6, 32), (7, 23), (7, 8), (8, 4), (8, 44), (9, 15)";

    private final String sql_select =
            "WITH \n" +
            "SRC_0x AS (\n" +
            "   SELECT \n" +
            "       S.*,\n" +
            "       S.ID_TIME *60                               AS START_TIME_IN_MIN,\n" +
            "       F.NAME,\n" +
            "       F.DURATION,\n" +
            "       (\n" +
            "           SELECT MIN(ID_SESSION) \n" +
            "           FROM TAB_SESSIONS F \n" +
            "           WHERE F.ID_SESSION > S.ID_SESSION\n" +
            "       )                                           AS ID_SESSION_NEXT \n" +
            "   FROM TAB_SESSIONS S\n" +
            "   JOIN TAB_FILMS F\n" +
            "       ON S.ID_FILM= F.ID_FILM\n" +
            ")\n" +
            ", SRC AS (\n" +
            "   SELECT\n" +
            "       S.ID_SESSION,\n" +
            "       F.ID_SESSION                                AS ID_SESSION_NEXT,\n" +
            "       S.ID_TIME,\n" +
            "       F.ID_TIME                                   AS ID_TIME_NEXT,\n" +
            "       S.NAME,\n" +
            "       F.NAME                                      AS NAME_NEXT,\n" +
            "       S.DURATION,\n" +
            "       F.DURATION                                  AS DURATION_NEXT,\n" +
            "       F.START_TIME_IN_MIN - S.START_TIME_IN_MIN - S.DURATION  AS PAUSE\n" +
            "   FROM SRC_0x F\n" +
            "   LEFT JOIN SRC_0x S\n" +
            "       ON F.ID_SESSION = S.ID_SESSION_NEXT\n" +
            ")\n";
    private final String sql_error =
            "SELECT\n" +
            "   NAME,\n" +
            "   ID_TIME                                         AS BEGIN_TIME,\n" +
            "   DURATION,\n" +
            "   NAME_NEXT,\n" +
            "   ID_TIME_NEXT                                    AS BEGIN_TIME_NEXT,\n" +
            "   DURATION_NEXT                                   AS DURATION_NEXT\n" +
            "FROM SRC \n" +
            "WHERE PAUSE < 0\n" +
            "ORDER BY BEGIN_TIME";
    private final String sql_ok =
            "SELECT\n" +
            "   NAME,\n" +
            "   ID_TIME                                         AS BEGIN_TIME,\n" +
            "   DURATION,\n" +
            "   ID_TIME_NEXT                                    AS BEGIN_TIME_NEXT,\n" +
            "   PAUSE\n" +
            "FROM SRC \n" +
            "WHERE PAUSE >= 30\n" +
            "ORDER BY PAUSE DESC, BEGIN_TIME";

    private java.sql.Connection connection;
    private Statement sqlQuery;
    private ResultSet dataQuery;

    public void open() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, username, password);
            connection.setAutoCommit(false);
            sqlQuery = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void init() {
        try {
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
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void initData() {
        try {
            sqlQuery.execute(sql_insert_times);
            sqlQuery.execute(sql_insert_days);
            sqlQuery.execute(sql_insert_films);
            sqlQuery.execute(sql_insert_sessions);
            sqlQuery.execute(sql_insert_tickets);
            sqlQuery.getConnection().commit();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void getDataQuery() {
        try {
            dataQuery = sqlQuery.executeQuery(sql_select + sql_error);

            while (dataQuery.next()) {
                System.out.print("\"" + dataQuery.getString("NAME") + "\" ");
                System.out.print(dataQuery.getInt("BEGIN_TIME") + " ");
                System.out.print(dataQuery.getInt("DURATION") + " ");
                System.out.print("\"" + dataQuery.getString("NAME_NEXT") + "\" ");
                System.out.print(dataQuery.getInt("BEGIN_TIME_NEXT") + " ");
                System.out.print(dataQuery.getInt("DURATION_NEXT"));
                System.out.println( );
            }
            System.out.println();

            dataQuery = sqlQuery.executeQuery(sql_select + sql_ok);

            while (dataQuery.next()) {
                System.out.print("\"" + dataQuery.getString("NAME") + " \" ");
                System.out.print(dataQuery.getInt("BEGIN_TIME") + " ");
                System.out.print(dataQuery.getInt("DURATION") + " ");
                System.out.print(dataQuery.getInt("BEGIN_TIME_NEXT") + " ");
                System.out.print(dataQuery.getInt("PAUSE"));
                System.out.println( );
            }
            System.out.println( );
        } catch (SQLException exception) {
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
