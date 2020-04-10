package me.cxis.agw.dao.mapper;

import me.cxis.agw.dao.model.ApiParamDO;

public interface ApiParamDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ApiParamDO record);

    int insertSelective(ApiParamDO record);

    ApiParamDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ApiParamDO record);

    int updateByPrimaryKey(ApiParamDO record);
}