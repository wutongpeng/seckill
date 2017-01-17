package org.seckill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by wutongpeng on 2017/1/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class SeckillServiceTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;
    @Test
    public void testGetSeckillList() throws Exception {
        List<Seckill> list = seckillService.getSeckillList();
        logger.info("list={}",list);
    }

    @Test
    public void testGetById() throws Exception {
        long id = 1001L;
        Seckill seckill = seckillService.getById(id);
        logger.info("seckill={}",seckill);
    }

    @Test
    public void testExportSeckillUrl() throws Exception {
        long id = 1001L;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        logger.info("exposer={}",exposer);
    }

    @Test
    public void testExecuteSeckill() throws Exception {
        long id = 1001L;
        long phone = 1356767678L;
        String md5 = "afdd3622c0618edaf856f6ca304f6b6f";
        try {
            SeckillExecution seckillExecution = seckillService.executeSeckill(id, phone, md5);
            logger.info("seckillExecution={}", seckillExecution);
        } catch (RepeatKillException e) {
            logger.error(e.getMessage(), e);
        } catch (SeckillCloseException e) {
            logger.error(e.getMessage(), e);
        }
    }
    @Test
    public void testSeckillLogin() throws Exception {
        long id = 1001L;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        if(exposer.isExposed()){
            logger.info("exposer={}",exposer);
            long phone = 1356767678L;
            String md5 = exposer.getMd5();
            try{
                SeckillExecution seckillExecution = seckillService.executeSeckill(id,phone,md5);
                logger.info("seckillExecution={}",seckillExecution);
            }catch (RepeatKillException e){
                logger.error(e.getMessage(),e);
            }catch (SeckillCloseException e){
                logger.error(e.getMessage(),e);
            }
        }else{
            logger.info("exposer={}",exposer);
        }
    }

}