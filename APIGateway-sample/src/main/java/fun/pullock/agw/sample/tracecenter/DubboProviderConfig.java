package fun.pullock.agw.sample.tracecenter;

import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.spring.ServiceBean;
import fun.pullock.agw.sample.tracecenter.service.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DubboProviderConfig extends DubboBaseConfig {

    @Bean
    public ProtocolConfig protocol() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setPort(20880);
        return protocolConfig;
    }

    @Bean
    public ProviderConfig provider() {
        ProviderConfig providerConfig = new ProviderConfig();
        providerConfig.setMonitor(monitorConfig());
        return providerConfig;
    }

    @Bean
    public ServiceBean<OrderService> orderServiceBean(OrderService orderService) {
        final ServiceBean<OrderService> serviceBean = new ServiceBean<>();
        // serviceBean.setVersion();
        serviceBean.setInterface(OrderService.class);
        serviceBean.setRef(orderService);
        serviceBean.setTimeout(10000);
        serviceBean.setRetries(0);
        return serviceBean;
    }
}
