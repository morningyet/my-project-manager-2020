package org.morningyet.myvhr2020.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.morningyet.myvhr2020.model.PoliticsStatus;
import org.morningyet.myvhr2020.model.PoliticsStatusExample;

public interface PoliticsStatusMapper {
    long countByExample(PoliticsStatusExample example);

    int deleteByExample(PoliticsStatusExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PoliticsStatus record);

    int insertSelective(PoliticsStatus record);

    List<PoliticsStatus> selectByExample(PoliticsStatusExample example);

    PoliticsStatus selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PoliticsStatus record, @Param("example") PoliticsStatusExample example);

    int updateByExample(@Param("record") PoliticsStatus record, @Param("example") PoliticsStatusExample example);

    int updateByPrimaryKeySelective(PoliticsStatus record);

    int updateByPrimaryKey(PoliticsStatus record);
}