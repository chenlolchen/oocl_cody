package dao.impl;

import dao.UserDao;
import org.springframework.stereotype.Repository;
import pojo.User;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
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
    @Resource(name = "ss")
    private EntityManagerFactory factory;

    public boolean register(User user) {
        boolean flag = false;
        EntityManager manager = factory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();

        manager.persist(user);

        tx.commit();
        flag = true;

        return flag;
//        try {
//            String sql = "insert into users(id, name, password, age) values(?, ?, ?, ?)";
//            Connection connection = null;
//            PreparedStatement preparedStatement = null;
//
//            try {
//                connection = dataSource.getConnection();
//                preparedStatement = connection.prepareStatement(sql);
//                preparedStatement.setString(1, user.getId());
//                preparedStatement.setString(2, user.getName());
//                preparedStatement.setString(3, user.getPassword());
//                preparedStatement.setInt(4, user.getAge());
//                preparedStatement.executeUpdate();
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                preparedStatement.close();
//                connection.close();
//            }
//            return true;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    public User login(String name, String password) {
        EntityManager manager = factory.createEntityManager();
        Query query = manager.createNativeQuery("select * from users where name = ? and password = ?", User.class);
        query.setParameter(1, name);
        query.setParameter(2, password);
        User user = (User) query.getSingleResult();
        return user;
    }
}
