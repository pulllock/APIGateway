package fun.pullock.agw.chains;

import fun.pullock.agw.manager.BlackIpManager;
import fun.pullock.agw.model.ErrorCode;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * 检查IP是否在黑名单中
 */
public class BlackIPCheckCommand extends AbstractCommand {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlackIPCheckCommand.class);

    @Resource
    private BlackIpManager blackIpManager;

    @Override
    public boolean execute(CommonContext context) {
        String clientIp = context.getClientIp();
        if (CollectionUtils.isNotEmpty(blackIpManager.queryByIp(clientIp))) {
            LOGGER.warn("not allowed to access ip: {}", clientIp);
            context.setRetCode(ErrorCode.IP_NOT_ALLOWED.getCode());
            context.setRetMsg(ErrorCode.IP_NOT_ALLOWED.getMsg());
            context.setSuccess(false);
            return true;
        }
        return false;
    }
}
