package me.cxis.agw.dao.mapper;

import me.cxis.agw.dao.model.OutDO;

public interface OutDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OutDO record);

    int insertSelective(OutDO record);

    OutDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OutDO record);

    int updateByPrimaryKey(OutDO record);
}