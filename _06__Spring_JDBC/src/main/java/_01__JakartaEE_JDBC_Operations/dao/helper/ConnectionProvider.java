package _01__JakartaEE_JDBC_Operations.dao.helper;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {

    private static Connection connect;
    public static Connection connectDB() {
        connect = null;
        try {
            String url = "jdbc:mysql://localhost:3306/school";
            String username = "root";
            String password = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connect;
    }

}

