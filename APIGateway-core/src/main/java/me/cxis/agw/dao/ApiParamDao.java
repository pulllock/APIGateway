package me.cxis.agw.dao;

import me.cxis.agw.dao.mapper.ApiParamDOMapper;
import me.cxis.agw.dao.model.ApiParamDO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class ApiParamDao {

    @Resource
    private ApiParamDOMapper apiParamDOMapper;

    public List<ApiParamDO> queryByApiId(Long apiId) {
        return apiParamDOMapper.selectByApiId(apiId);
    }
}


