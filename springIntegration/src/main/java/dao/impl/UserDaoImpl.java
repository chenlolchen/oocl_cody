package dao.impl;

import dao.UserDao;
import org.springframework.stereotype.Repository;
import pojo.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Created by CHENCO7 on 8/10/2017.
 */
@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext(name="un")
    private EntityManager manager;

    public User addUser(User user) {
        manager.persist(user);
        return user;
    }

    public User loadUser(String name, String password) {
        Query query = manager.createNativeQuery("select * from users where name = ? and password = ?", User.class);
        query.setParameter(1, name);
        query.setParameter(2, password);
        // NoResultException
        User user = (User) query.getSingleResult();
        return user;
    }
}
