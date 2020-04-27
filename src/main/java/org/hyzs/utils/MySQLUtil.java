package org.hyzs.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author hux
 * @date 2019/12/10 14:21
 */
public class MySQLUtil {
    private static Connection mConnect;
    static {
        try {
            System.out.println("init---");
            Class.forName("com.mysql.jdbc.Driver");
            mConnect=DriverManager.getConnection("jdbc:mysql://172.16.18.28:3306/judicial_documents?useSSL=false&useUnicode=true&characterEncoding=utf-8&autoReconnect=true", "guest01", "AI@hx123456");
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static Connection getConnection() {
        return mConnect;

    }
    public static void  close() {
        try {
            mConnect.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
