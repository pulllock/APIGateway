package me.cxis.agw.chains;

import me.cxis.agw.chains.support.IPCounter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

import static me.cxis.agw.model.ErrorCode.FREQUENTLY_ACCESS;

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
        context.setRetCode(FREQUENTLY_ACCESS.getCode());
        context.setRetMsg(FREQUENTLY_ACCESS.getMsg());
        context.setSuccess(false);
        return true;
    }
}
