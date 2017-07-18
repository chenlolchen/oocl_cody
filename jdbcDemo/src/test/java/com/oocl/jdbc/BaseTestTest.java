package com.oocl.jdbc;

import com.oocl.jdbc.util.DBUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.*;
import java.util.*;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by CHENCO7 on 7/18/2017.
 */
public class BaseTestTest {
    private static Connection connection;

    @BeforeClass
    public static void init() throws Exception {
        connection = DBUtil.createConnection();
    }

    @AfterClass
    public static void destroy() throws SQLException {
        DBUtil.close(connection, null, null);
    }

    @Test
    public void test() {
        String sql = "INSERT INTO customers(id, cname, sex, birth, sal) VALUES (seq01.nextval,?,?,?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setInt(1, 5);
            preparedStatement.setString(1, "lol");
            preparedStatement.setBoolean(2, true);
            Date date = new Date();
            preparedStatement.setDate(3, new java.sql.Date(date.getTime()));
            preparedStatement.setDouble(4, 23.65);
            int m = preparedStatement.executeUpdate();
            preparedStatement.close();
            System.out.println(m);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(null, preparedStatement, null);
        }
    }

    @Test
    public void testUpdate() {
        String sql = "update customers set NAME = ? WHERE id = 4 OR id = 1";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "test update name ....");
            int m = preparedStatement.executeUpdate();
            System.out.println(m);
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDelete() {
        String sql = "delete customers where id = 10";
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(sql);
            int m = statement.executeUpdate();
            statement.close();
            System.out.println(m);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindALl() throws SQLException {
        String sql = "select id, name t_name from customers";
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(sql);
            // 二维表
            rs = statement.executeQuery();
            while (rs.next()){
                String name = rs.getString("t_name"); //使用的是别名
                int id = rs.getInt("id");
                System.out.println(id + "\t" + name);
            }
            DBUtil.close(null, statement, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}