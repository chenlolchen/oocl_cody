package dao.impl;

import dao.UserDao;
import org.springframework.stereotype.Repository;
import pojo.User;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by CHENCO7 on 8/9/2017.
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Resource(name = "dataSource")
    private DataSource dataSource;

    public boolean register(User user) {
        try {
            String sql = "insert into users(id, name, password, age) values(?, ?, ?, ?)";
            Connection connection = null;
            PreparedStatement preparedStatement = null;

            try {
                connection = dataSource.getConnection();
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, user.getId());
                preparedStatement.setString(2, user.getName());
                preparedStatement.setString(3, user.getPassword());
                preparedStatement.setInt(4, user.getAge());
                preparedStatement.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                preparedStatement.close();
                connection.close();
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public User login(String name, String password) {
        System.out.println(password);
        try {
            String sql = "select * from users where name = ? and password = ?";

            Connection connection = null;
            PreparedStatement preparedStatement = null;
            ResultSet rs = null;
            try {
                connection = dataSource.getConnection();
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, password);
                rs = preparedStatement.executeQuery();
                if (rs.next()) {
                    User user = new User();
                    user.setId(rs.getString("id"));
                    user.setName(rs.getString("name"));
                    user.setAge(rs.getInt("age"));
                    return user;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                rs.close();
                preparedStatement.close();
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
