package fun.pullock.agw.chains;

import fun.pullock.agw.chains.support.IPCounter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

import static fun.pullock.agw.model.ErrorCode.FREQUENTLY_ACCESS;

/**
 * 流控，指定时间内同一个IP不能超过指定的次数
 */
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
