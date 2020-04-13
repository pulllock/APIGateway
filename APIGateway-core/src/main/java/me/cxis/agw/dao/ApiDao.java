package me.cxis.agw.dao;

import me.cxis.agw.dao.mapper.ApiDOMapper;
import me.cxis.agw.dao.model.ApiDO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class ApiDao {

    @Resource
    private ApiDOMapper apiDOMapper;

    public ApiDO queryByCode(String code) {
        return apiDOMapper.selectByCode(code);
    }
}
