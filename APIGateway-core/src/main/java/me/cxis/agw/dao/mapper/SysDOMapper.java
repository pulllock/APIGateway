package me.cxis.agw.dao.mapper;

import me.cxis.agw.dao.model.SysDO;

public interface SysDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysDO record);

    int insertSelective(SysDO record);

    SysDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysDO record);

    int updateByPrimaryKey(SysDO record);
}