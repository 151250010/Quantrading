package cn.edu.nju.p.dao;

import cn.edu.nju.p.QuantradingApplication;
import cn.edu.nju.p.po.StockPO;
import com.sun.javafx.binding.BindingHelperObserver;
import org.apache.tomcat.jni.Local;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.junit.Assert.*;
/**
 * attention! must use the mysql on the server,because the column current_time has been modified.
 */
@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = QuantradingApplication.class)
public class StockDaoTest {

    @Autowired
//    提示说没有找到bean??????
    private StockDao stockDao;
    private LocalDate date = LocalDate.of(2013, Month.MAY, 13);
    private String code = "000001";
    private String name = "深发展A";


    @Test
    public void getStockPO() throws Exception {
        System.out.println("=================================================");
        StockPO po = stockDao.getStockPO(code, date);
        if (po == null) {
            System.out.println("po是null！！");
        } else {
            System.out.println(po.toString());
        }
        System.out.println("==================================================");
    }

    @Test
    public void getStockOpen() throws Exception {
//        assertEquals(stockDao.getStockOpen(code, date), 18.01, 0.01);
        System.out.println(stockDao.getStockOpen(code,date));
    }

    @Test
    public void getStockHigh() throws Exception {
        assertEquals(stockDao.getStockHigh(code, date), 18.92, 0.01);
    }

    @Test
    public void getStockLow() throws Exception {
        assertEquals(stockDao.getStockLow(code, date), 18.00, 0.01);
    }

    @Test
    public void getStockClose() throws Exception {
        assertEquals(stockDao.getStockClose(code, date), 18.68, 0.01);
    }

    @Test
    public void getStockVolume() throws Exception {
        assertEquals(stockDao.getStockVolume(code, date), 156909800, 0.0);
    }

    @Test
    public void getStockAdjClose() throws Exception {
        assertEquals(stockDao.getStockAdjClose(code, date), 6.66, 0.01);
    }

    @Test
    public void getStockName() throws Exception {
        assertEquals(stockDao.getStockName(code), "深发展A");
    }

    @Test
    public void getStockMarket() throws Exception {
        assertEquals(stockDao.getStockMarket(code), "SZ");
    }

    @Test
    public void getStockCode() throws Exception {
        assertEquals("000001", stockDao.getStockCode(name));
    }

    @Test
    public void getPOList() throws Exception {
        System.out.println(stockDao.getPOList(date.toString()));
    }

    @Test
    public void getPOCodes() throws Exception {
        List<String> list = stockDao.getPOCodes();
        System.out.println(list);
    }

    @Test
    public void getStockSector() throws Exception {

    }

    @Test
    public void getStockBySector() throws Exception {

    }

    @Test
    public void getAllStocks() throws Exception {

    }

    @Test
    public void insertIntoStockDatabase() throws Exception {

    }


}