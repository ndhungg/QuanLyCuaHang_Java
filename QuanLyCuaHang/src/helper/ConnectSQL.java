package helper;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectSQL {

    //Lấy chuỗi url Connection
    public static Connection getConnection() throws Exception {
//        try {
//            try {
//                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            } catch (ClassNotFoundException e) {
//                throw new Exception("SQL JDBC not found !!! ");
//            }
//            String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyBanHang_Java";
//            return DriverManager.getConnection(url, "sa", "123456");
//        } catch (ClassNotFoundException | SQLException e) {
//            return null;
//        }

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyBanHang_Java";
        String dbUserName = "sa";
        String dbPassWord = "123456";
        Connection con = DriverManager.getConnection(connectionUrl,dbUserName,dbPassWord);
        return con;
    }
}
