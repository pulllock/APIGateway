package fun.pullock.agw.dao;

import fun.pullock.agw.dao.mapper.SysDOMapper;
import fun.pullock.agw.dao.model.SysDO;
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
