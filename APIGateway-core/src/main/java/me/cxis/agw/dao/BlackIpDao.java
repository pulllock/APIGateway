package me.cxis.agw.dao;

import me.cxis.agw.dao.mapper.BlackIpDOMapper;
import me.cxis.agw.dao.model.BlackIpDO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class BlackIpDao {

    @Resource
    private BlackIpDOMapper blackIpDOMapper;

    public List<BlackIpDO> queryByIp(String ip) {
        return blackIpDOMapper.selectByIp(ip);
    }

}
