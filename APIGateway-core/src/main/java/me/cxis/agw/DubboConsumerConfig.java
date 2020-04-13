package me.cxis.agw;

import org.apache.dubbo.config.ConsumerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DubboConsumerConfig extends DubboBaseConfig {

    @Bean
    public ConsumerConfig consumerConfig() {
        return new ConsumerConfig();
    }
}
