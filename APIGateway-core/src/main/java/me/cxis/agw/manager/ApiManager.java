package me.cxis.agw.manager;

import me.cxis.agw.dao.ApiDao;
import me.cxis.agw.dao.model.ApiDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ApiManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiManager.class);

    @Resource
    private ApiDao apiDao;

    public ApiDO queryByCode(String code) {
        return apiDao.queryByCode(code);
    }
}
