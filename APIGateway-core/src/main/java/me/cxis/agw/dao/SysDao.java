package me.cxis.agw.dao;

import me.cxis.agw.dao.mapper.SysDOMapper;
import me.cxis.agw.dao.model.SysDO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class SysDao {

    @Resource
    private SysDOMapper sysDOMapper;

    public SysDO queryByName(String name) {
        return sysDOMapper.selectByName(name);
    }
}
