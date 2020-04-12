package me.cxis.agw.chains;

import me.cxis.agw.manager.BlackIpManager;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

import static me.cxis.agw.model.ErrorCode.IP_NOT_ALLOWED;

public class BlackIPCheckCommand extends AbstractCommand {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlackIPCheckCommand.class);

    @Resource
    private BlackIpManager blackIpManager;

    @Override
    public boolean execute(CommonContext context) {
        String clientIp = context.getClientIp();
        if (CollectionUtils.isNotEmpty(blackIpManager.queryByIp(clientIp))) {
            LOGGER.warn("not allowed to access ip: {}", clientIp);
            context.setRetCode(IP_NOT_ALLOWED.getCode());
            context.setRetMsg(IP_NOT_ALLOWED.getMsg());
            context.setSuccess(false);
            return true;
        }
        return false;
    }
}
