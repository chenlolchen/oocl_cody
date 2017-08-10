import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by CHENCO7 on 8/10/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class TestUser {
    private static EntityManagerFactory factory;
    private EntityManager manager;

    @BeforeClass
    public static void init(){
//        factory = Persistence.createEntityManagerFactory("un");
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        factory = (EntityManagerFactory) context.getBean("entityManagerFactory");
    }

    @AfterClass
    public static void destory(){
        factory.close();
    }

    @Before
    public void start(){
        manager = factory.createEntityManager();
    }

    @After
    public void end(){
        manager.close();
    }

    @Test
    public void testSave(){
        User user = new User();
        user.setName("chen");
        user.setAge(23);
        user.setPassword("123");

        EntityTransaction tx = manager.getTransaction();
        tx.begin();

        manager.persist(user);

        tx.commit();
    }

    @Test
    public void testLoad(){
        User user = manager.find(User.class, 1);
        System.out.println(user);
    }

    @Test
    public void testUpdate(){
        User user = manager.find(User.class, 1);
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        user.setAge(111);
        tx.commit();
    }

    @Test
    public void testDelete(){
        User user = manager.find(User.class, 1);
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.remove(user);
        tx.commit();
        // 删除后，对象仍然存在
        System.out.println(user);
    }

}

