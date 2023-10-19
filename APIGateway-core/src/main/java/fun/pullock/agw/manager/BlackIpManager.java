package fun.pullock.agw.manager;

import fun.pullock.agw.dao.BlackIpDao;
import fun.pullock.agw.dao.model.BlackIpDO;
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
