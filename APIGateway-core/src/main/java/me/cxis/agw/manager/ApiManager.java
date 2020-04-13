package me.cxis.agw.manager;

import me.cxis.agw.dao.ApiDao;
import me.cxis.agw.dao.ApiParamDao;
import me.cxis.agw.dao.model.ApiDO;
import me.cxis.agw.dao.model.ApiParamDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class ApiManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiManager.class);

    @Resource
    private ApiDao apiDao;

    @Resource
    private ApiParamDao apiParamDao;

    public ApiDO queryByCode(String code) {
        return apiDao.queryByCode(code);
    }

    public List<ApiParamDO> queryApiParamsByApiId(Long apiId) {
        return apiParamDao.queryByApiId(apiId);
    }
}
