package Database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {

    private static Connection con = null;

    private  static void createConnection() {
        if (con == null) {
            try {

                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3307/bank", "root", "1234");
            } catch (ClassNotFoundException | SQLException e) {
                System.err.println(e.getMessage());
            }
        }

    }

    public static Connection getConnection() {
        createConnection();
        return con;
    }

    public static ResultSet getData(String sql) throws Exception {
        return getConnection().createStatement().executeQuery(sql);
    }

    public static void updateData(String sql) throws Exception {
        getConnection().createStatement().executeUpdate(sql);
    }

}
