package me.cxis.agw.dao.mapper;

import me.cxis.agw.dao.model.OutIpDO;
import org.apache.ibatis.annotations.Param;

public interface OutIpDOMapper {

    int deleteByPrimaryKey(Long id);

    int insert(OutIpDO record);

    int insertSelective(OutIpDO record);

    OutIpDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OutIpDO record);

    int updateByPrimaryKey(OutIpDO record);

    OutIpDO selectByOutIdAndIp(@Param("outId") Long outId, @Param("ip") String clientIp);
}