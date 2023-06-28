package connectJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectJDBC {

    String url = "jdbc:mysql://localhost:3306/StudentDB1"; //
    String username = "root";
    String password = "12345678";

    public Connection getConnection() {

        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver"); // nap driver cho ung dung de ket noi voi database mysql
            connection = DriverManager.getConnection(url, username, password);
           // System.out.println("Ket noi thanh cong");
        } catch (SQLException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            return connection;
        }
    }

    public void closeConnection(Connection connection) {
        if (connection != null) { // kiem tra xem connection co null hay khong
            try {
                connection.close(); // dong ket noi
              // System.out.println("Dong ket noi thanh cong");
            } catch (SQLException e) {
                System.out.println(e.toString());
                e.printStackTrace();
            }
        }
    }
}


