package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
    // 数据库连接信息
    private static final String URL = "jdbc:mysql://localhost:3306/db_web_work";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "mysql";

    // 获取数据库连接的方法
    public static Connection getConnection() {
        Connection connection = null;
        try {
            // 加载数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 建立数据库连接
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
