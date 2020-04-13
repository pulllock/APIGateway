package me.cxis.agw.manager;

import me.cxis.agw.dao.SysDao;
import me.cxis.agw.dao.model.SysDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class SysManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysManager.class);

    @Resource
    private SysDao sysDao;

    public SysDO queryByName(String name) {
        return sysDao.queryByName(name);
    }
}
