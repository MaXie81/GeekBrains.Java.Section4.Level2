public class Test {
    public static void main(String[] args) {
        Connection connection = new Connection();
        connection.open();
        connection.init();
        connection.initData();
        connection.getDataQuery();
        connection.close();
    }
}
