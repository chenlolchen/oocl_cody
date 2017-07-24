package dao.impl;

import dao.UserDao;
import pojo.User;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by CHENCO7 on 7/24/2017.
 */
public class UserDaoImpl implements UserDao {
    public int addUser(User user) {
        String sql = "insert into users(id, name, salary, birth, sex) values(seq01.nextval, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        int m = 0;
        try {
            connection = DBUtil.createConnectionWithDataSource();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setDouble(2, user.getSalary());
            preparedStatement.setDate(3, new java.sql.Date(user.getBirth().getTime()));
            preparedStatement.setBoolean(4, user.getSex());
            m = preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, preparedStatement, null);
        }
        return m;
    }

    public User loadUser(String name) {
        String sql = "select * from users where name = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        User user = null;
        try {
            connection = DBUtil.createConnectionWithDataSource();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            rs = preparedStatement.executeQuery();
            if (rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setSalary(rs.getDouble("salary"));
                user.setBirth(rs.getDate("birth"));
                user.setSex(rs.getBoolean("sex"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, preparedStatement, rs);
        }
        return user;
    }
}
