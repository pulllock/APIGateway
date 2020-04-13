package me.cxis.agw.manager;

import me.cxis.agw.dao.OutApiDao;
import me.cxis.agw.dao.OutDao;
import me.cxis.agw.dao.OutIpDao;
import me.cxis.agw.dao.model.OutApiDO;
import me.cxis.agw.dao.model.OutDO;
import me.cxis.agw.dao.model.OutIpDO;
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
