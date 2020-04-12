package me.cxis.agw.dao;

import me.cxis.agw.dao.mapper.OutDOMapper;
import me.cxis.agw.dao.model.OutDO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class OutDao {

    @Resource
    private OutDOMapper outDOMapper;

    public OutDO queryByName(String name) {
        return outDOMapper.selectByName(name);
    }
}
