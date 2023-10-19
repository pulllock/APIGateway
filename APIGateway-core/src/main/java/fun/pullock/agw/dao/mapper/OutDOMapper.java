package fun.pullock.agw.dao.mapper;

import fun.pullock.agw.dao.model.OutDO;

public interface OutDOMapper {

    int deleteByPrimaryKey(Long id);

    int insert(OutDO record);

    int insertSelective(OutDO record);

    OutDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OutDO record);

    int updateByPrimaryKey(OutDO record);

    OutDO selectByName(String name);
}