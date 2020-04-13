package me.cxis.agw.dao;

import me.cxis.agw.dao.mapper.OutIpDOMapper;
import me.cxis.agw.dao.model.OutIpDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class OutIpDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(OutIpDao.class);

    @Resource
    private OutIpDOMapper outIpDOMapper;

    public OutIpDO queryByOutIdAndIp(Long outId, String clientIp) {
        return outIpDOMapper.selectByOutIdAndIp(outId, clientIp);
    }
}
