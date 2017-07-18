package com.oocl.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by CHENCO7 on 7/18/2017.
 */
public class BaseTest{
    public static void main(String[] args) throws Exception {
        String className = "oracle.jdbc.OracleDriver";
        String url = "jdbc:oracle:thin:@//ZHA-ITA077-w7:1521/ita3";
        String username = "cody";
        String password = "123";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        // 针对接口编程
        Class.forName(className);
        connection = DriverManager.getConnection(url, username, password);
        System.out.println(connection.getClass().getName());

//        String sql = "insert into tt(id, name) values(?, ?)";
////        String sql2 = "insert into tt(name) values(?)";
//        preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setInt(1,4);
//        preparedStatement.setString(2,"aaa");

        preparedStatement = connection.prepareStatement("SELECT * FROM tt");
        rs = preparedStatement.executeQuery();
        while (rs.next()){
            System.out.println(rs);
        }

        int m = preparedStatement.executeUpdate();

        connection.close();
    }
}
