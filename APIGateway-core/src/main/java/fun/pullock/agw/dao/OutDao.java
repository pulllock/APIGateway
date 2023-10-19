package fun.pullock.agw.dao;

import fun.pullock.agw.dao.mapper.OutDOMapper;
import fun.pullock.agw.dao.model.OutDO;
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
