package me.cxis.agw.dao.mapper;

import me.cxis.agw.dao.model.OutApiDO;
import org.apache.ibatis.annotations.Param;

public interface OutApiDOMapper {

    int deleteByPrimaryKey(Long id);

    int insert(OutApiDO record);

    int insertSelective(OutApiDO record);

    OutApiDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OutApiDO record);

    int updateByPrimaryKey(OutApiDO record);

    OutApiDO selectByOutIdAndApiId(@Param("outId") Long outId, @Param("apiId") Long apiId);
}