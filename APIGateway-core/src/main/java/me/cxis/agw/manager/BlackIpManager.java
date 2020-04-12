package me.cxis.agw.manager;

import me.cxis.agw.dao.BlackIpDao;
import me.cxis.agw.dao.model.BlackIpDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class BlackIpManager {

    @Resource
    private BlackIpDao blackIpDao;

    public List<BlackIpDO> queryByIp(String ip) {
        return blackIpDao.queryByIp(ip);
    }
}
