package fun.pullock.agw.dao;

import fun.pullock.agw.dao.mapper.OutApiDOMapper;
import fun.pullock.agw.dao.model.OutApiDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class OutApiDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(OutApiDao.class);

    @Resource
    private OutApiDOMapper outApiDOMapper;

    public OutApiDO queryByOutIdAndApiId(Long outId, Long apiId) {
        return outApiDOMapper.selectByOutIdAndApiId(outId, apiId);
    }
}
