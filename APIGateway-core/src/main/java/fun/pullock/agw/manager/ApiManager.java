package fun.pullock.agw.manager;

import fun.pullock.agw.dao.ApiDao;
import fun.pullock.agw.dao.ApiParamDao;
import fun.pullock.agw.dao.model.ApiDO;
import fun.pullock.agw.dao.model.ApiParamDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
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

    @Cacheable(value = "apiByCode", key = "#code", unless = "#result == null")
    public ApiDO queryByCode(String code) {
        return apiDao.queryByCode(code);
    }

    public List<ApiParamDO> queryApiParamsByApiId(Long apiId) {
        return apiParamDao.queryByApiId(apiId);
    }
}
