package fun.pullock.agw.manager;

import fun.pullock.agw.dao.OutApiDao;
import fun.pullock.agw.dao.OutDao;
import fun.pullock.agw.dao.OutIpDao;
import fun.pullock.agw.dao.model.OutApiDO;
import fun.pullock.agw.dao.model.OutDO;
import fun.pullock.agw.dao.model.OutIpDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class OutManager {

    @Resource
    private OutDao outDao;

    @Resource
    private OutApiDao outApiDao;

    @Resource
    private OutIpDao outIpDao;

    public OutDO queryByName(String name) {
        return outDao.queryByName(name);
    }

    public OutApiDO queryByOutIdAndApiId(Long outId, Long apiId) {
        return outApiDao.queryByOutIdAndApiId(outId, apiId);
    }

    public OutIpDO queryByOutIdAndIp(Long outId, String clientIp) {
        return outIpDao.queryByOutIdAndIp(outId, clientIp);
    }
}
