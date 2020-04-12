package me.cxis.agw;

import me.cxis.agw.chains.support.IPCounter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IPCounterConfig {

    @Value("${ipCounter.timeRule}")
    private int timeRule;

    @Value("${ipCounter.countRule}")
    private int countRule;

    @Bean
    public IPCounter ipCounter() {
        // TODO 从动态配置中心获取
        return new IPCounter(countRule, timeRule);
    }

    // TODO 使用动态配置中心配置，更改后动态修改
    public void dynamicConfig() {
        // TODO 监听配置中心变化
        int countRule = 111;
        int timeRule = 2;
        this.ipCounter().setCountRule(countRule);
        this.ipCounter().setTimeRule(timeRule);
    }
}
