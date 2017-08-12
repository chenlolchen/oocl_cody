package org.seckill.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by chen on 2016/5/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"
})
public class SeckillServiceImplTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @Test
    public void testGetSeckillList() throws Exception {
        List<Seckill> list = seckillService.getSeckillList();
        logger.info("list={}", list);
    }

    @Test
    public void testGetById() throws Exception {
        long id = 1000;
        Seckill seckill = seckillService.getById(id);
        logger.info("seckill={}", seckill);
    }

    @Test
    public void testSeckillLogic() throws Exception {
        long id = 1000;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        /*logger.info("exposer={}",exposer);*/
        if (exposer.isExposed()) {
            logger.info("exposer={}", exposer);
            long phone = 13622254896L;
            String md5 = exposer.getMd5();
            try {
                SeckillExecution execution = seckillService.executeSeckill(id, phone, md5);
            } catch (RepeatKillException e) {
                logger.error(e.getMessage());
            } catch (SeckillCloseException e) {
                logger.error(e.getMessage());
            }
        }
    }

    @Test
    public void testExecuteSeckill() throws Exception {
        long id = 1000;
        long phone = 1362222333L;
        String md5 = "cffbdcd664efa71e6f48cc563f1c18f1";
        SeckillExecution execution = seckillService.executeSeckill(id, phone, md5);
        logger.info("result={}", execution);
    }

    @Test
    public void testGetSeckillListByPage() throws Exception {
        int page = 1;
        int pageSize = 3;
        List<Seckill> list = seckillService.getSeckillListByPage(page, pageSize);
        logger.info("result={}", list);
    }

    @Test
    public void testExecuteSeckillProcedure() throws Exception {
        long seckillId = 1001;
        long phone = 13631232233L;
        Exposer exposer = seckillService.exportSeckillUrl(seckillId);
        if (exposer.isExposed()) {
            String md5 = exposer.getMd5();
            SeckillExecution excution = seckillService.executeSeckillProcedure(seckillId, phone, md5);
            logger.info(excution.getStateInfo());
        }
    }
}