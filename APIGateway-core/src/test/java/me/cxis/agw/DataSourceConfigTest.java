package me.cxis.agw;


import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;

import javax.annotation.Resource;
import javax.sql.DataSource;

import static org.junit.Assert.assertTrue;

public class DataSourceConfigTest extends BaseTest {

    @Resource
    private DataSource dataSource;

    @Test
    public void testDataSource() {
        System.out.println(dataSource);
        assertTrue(dataSource instanceof DruidDataSource);
    }

}
