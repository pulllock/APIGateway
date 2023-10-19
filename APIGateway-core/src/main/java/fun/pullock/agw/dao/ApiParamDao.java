package fun.pullock.agw.dao;

import fun.pullock.agw.dao.mapper.ApiParamDOMapper;
import fun.pullock.agw.dao.model.ApiParamDO;
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


