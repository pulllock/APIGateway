package me.cxis.agw;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource dataSource() {
        return new DruidDataSource();
    }

    /**
     * Druid的监控管理后台
     * @return
     */
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String,String> initParams = new HashMap<>();

        // 用户名、密码
        initParams.put("loginUsername","admin");
        initParams.put("loginPassword","admin");

        // IP白名单
        initParams.put("allow","");

        // 黑名单，黑白名单重复的时候，黑名单优先级高
        initParams.put("deny","");

        // 是否能重置数据
        initParams.put("resetEnable", "false");

        servletRegistrationBean.setInitParameters(initParams);
        return servletRegistrationBean;
    }


    /**
     * Druid的服务过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());

        Map<String,String> initParams = new HashMap<>();
        // 忽略过滤的格式
        initParams.put("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");

        filterRegistrationBean.setInitParameters(initParams);

        // 过滤规则
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));

        return  filterRegistrationBean;
    }

}
