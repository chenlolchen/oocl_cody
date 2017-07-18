package com.oocl.jdbc;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by CHENCO7 on 7/18/2017.
 */
public class DbcpTest {
    public static void main(String[] args) throws Exception {
        BasicDataSource dataSource = new BasicDataSource();
        String className = "oracle.jdbc.OracleDriver";
        String url = "jdbc:oracle:thin:@//ZHA-ITA077-w7:1521/ita3";
        String username = "cody";
        String password = "123";
        dataSource.setUrl(url);
        dataSource.setDriverClassName(className);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        System.out.println(dataSource);
        dataSource.setMaxActive(2);
        final Connection connection = dataSource.getConnection();
        System.out.println(connection);
        Connection connection2 = dataSource.getConnection();
        System.out.println(connection2);
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    connection.close();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        Connection connection3 = dataSource.getConnection();
        System.out.println(connection3);
        connection.close();
    }
}
