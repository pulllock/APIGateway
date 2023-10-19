package fun.pullock.agw.dao.mapper;

import fun.pullock.agw.dao.model.ApiDO;

public interface ApiDOMapper {

    int deleteByPrimaryKey(Long id);

    int insert(ApiDO record);

    int insertSelective(ApiDO record);

    ApiDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ApiDO record);

    int updateByPrimaryKey(ApiDO record);

    ApiDO selectByCode(String code);
}