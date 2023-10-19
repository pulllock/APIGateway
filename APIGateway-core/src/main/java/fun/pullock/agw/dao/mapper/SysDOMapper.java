package fun.pullock.agw.dao.mapper;

import fun.pullock.agw.dao.model.SysDO;

public interface SysDOMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysDO record);

    int insertSelective(SysDO record);

    SysDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysDO record);

    int updateByPrimaryKey(SysDO record);

    SysDO selectByName(String name);
}