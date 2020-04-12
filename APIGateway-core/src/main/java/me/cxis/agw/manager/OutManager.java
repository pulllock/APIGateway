package me.cxis.agw.manager;

import me.cxis.agw.dao.OutDao;
import me.cxis.agw.dao.model.OutDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class OutManager {

    @Resource
    private OutDao outDao;

    public OutDO queryByName(String name) {
        return outDao.queryByName(name);
    }
}
