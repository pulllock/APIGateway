package me.cxis.agw.dao.mapper;

import me.cxis.agw.dao.model.BlackIpDO;

public interface BlackIpDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BlackIpDO record);

    int insertSelective(BlackIpDO record);

    BlackIpDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BlackIpDO record);

    int updateByPrimaryKey(BlackIpDO record);
}