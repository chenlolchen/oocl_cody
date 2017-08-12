import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.*;

import javax.persistence.*;
import java.util.List;

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
    public void testSaveOrder(){
        Customer customer = new Customer("chen1");
        Address address = new Address("珠海", true);
        Address address2 = new Address("北京", false);
        Address address3 = new Address("深圳", false);
        customer.getAddressList().add(address);
        customer.getAddressList().add(address2);
        customer.getAddressList().add(address3);

        Order order = new Order("process3333");

        OrderItem item1 = new OrderItem("xiaocai", 42.66);
        OrderItem item2 = new OrderItem("aaa", 72.13);

        order.getOrderItemList().add(item1);
        order.getOrderItemList().add(item2);

        customer.getOrder().add(order);

        EntityTransaction tx = manager.getTransaction();
        tx.begin();

        manager.persist(item1);
        manager.persist(item2);
        manager.persist(order);
        manager.persist(customer);

        tx.commit();
    }

    @Test
    public void testComment(){
        Order order = manager.find(Order.class, "8a5e9d1a5dd42db1015dd42db6c00002");
        order.getComment().add("comment");
    }

    @Test
    public void testFindAddress(){
        Query query = manager.createNativeQuery("SELECT * FROM customer WHERE id =:customer_id", Customer.class);
        Customer customer = (Customer) query.setParameter("customer_id", "8a5e9d1a5dd0c091015dd0c095dd0003").getSingleResult();
        System.out.println(customer);
        List<Address> list = customer.getAddressList();
        for (Address a : list){
            System.out.println(a);
        }
    }

    @Test
    public void testSetDefaultAddress(){
        Query query = manager.createNativeQuery("SELECT * FROM customer WHERE id =:customer_id", Customer.class);
        Customer customer = (Customer) query.setParameter("customer_id", "8a5e9d1a5dd0c091015dd0c095dd0003").getSingleResult();

        customer.setDefaultAddress("深圳");

        EntityTransaction tx = manager.getTransaction();
        tx.begin();

        System.out.println(customer);
        manager.persist(customer);

        tx.commit();
    }

    @Test
    public void testFindDefaultAddress(){

    }

    @Test
    public void testSaveOrder2(){
        Customer customer = manager.find(Customer.class, "8a5e9d1a5dd0a371015dd0a376580003");
        Order order = new Order("process666");

        OrderItem item1 = new OrderItem("lol", 111.66);
        OrderItem item2 = new OrderItem("bfaw", 55.13);
        OrderItem item3 = new OrderItem("cccc", 97.99);

        order.getOrderItemList().add(item1);
        order.getOrderItemList().add(item2);
        order.getOrderItemList().add(item3);

        customer.getOrder().add(order);

        EntityTransaction tx = manager.getTransaction();
        tx.begin();

        manager.persist(item1);
        manager.persist(item2);
        manager.persist(item3);
        manager.persist(order);
        manager.persist(customer);

        tx.commit();

    }

    @Test
    public void testDeleteOrder(){
        Order order = manager.find(Order.class, "8a5e9d1a5dd0a7c2015dd0a7c6a40003");
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.remove(order);
        tx.commit();
    }

    @Test
    public void testDeleteCustomer(){
        Customer customer = manager.find(Customer.class, "8a5e9d1a5dd0adfb015dd0ae00210003");
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.remove(customer);
        tx.commit();
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

