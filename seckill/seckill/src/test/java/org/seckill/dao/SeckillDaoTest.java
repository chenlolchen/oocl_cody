package org.seckill.dao;

import org.seckill.entity.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by chen on 2016/5/27.
 * 配置spring和junit整合，junit启动时加载spring IOC容器
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {

    @Resource
    private SeckillDao seckillDao;

    private Logger logger = LoggerFactory.getLogger("test");

    @Test
    public void testQueryById() throws Exception {
        long id = 1000;

        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill.getName());
        System.out.println(seckill);
        logger.info("lol");
    }

    @Test
    public void testQueryAll() throws Exception {
        List<Seckill> seckills = seckillDao.queryAll(0,100);
        for (Seckill seckill : seckills) {
            System.out.println(seckill);
        }
    }

    @Test
    public void testReduceNumber() throws Exception {
        Date killtime = new Date();
        int reduceCount = seckillDao.reduceNumber(1000L, killtime);
        System.out.println("reduceCount=" + reduceCount);
    }


    @Test
    public void testListCount() throws Exception {
        int result = seckillDao.listCount();
        System.out.println("result = " + result);
    }
}