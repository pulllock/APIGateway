package me.cxis.agw.chains;

import me.cxis.agw.chains.support.IPCounter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

public class FlowControlCommand extends AbstractCommand {

    private static final Logger LOGGER = LoggerFactory.getLogger(FlowControlCommand.class);

    @Resource
    private IPCounter ipCounter;

    @Override
    public boolean execute(CommonContext context) {
        String clientIp = context.getClientIp();
        if (ipCounter.allow(clientIp)) {
            return false;
        }

        LOGGER.warn("ip flow control for client: {}", clientIp);
        return true;
    }
}
