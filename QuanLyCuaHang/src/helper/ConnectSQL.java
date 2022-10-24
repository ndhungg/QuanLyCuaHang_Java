package helper;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectSQL {

    public static Connection getConnection() throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyBanHang_Java";
        String dbUserName = "sa";
        String dbPassWord = "123456";
        Connection con = DriverManager.getConnection(connectionUrl,dbUserName,dbPassWord);
        return con;
    }
}
