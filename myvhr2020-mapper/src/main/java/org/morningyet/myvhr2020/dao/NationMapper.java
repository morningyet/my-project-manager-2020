package org.morningyet.myvhr2020.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.morningyet.myvhr2020.model.Nation;
import org.morningyet.myvhr2020.model.NationExample;

public interface NationMapper {
    long countByExample(NationExample example);

    int deleteByExample(NationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Nation record);

    int insertSelective(Nation record);

    List<Nation> selectByExample(NationExample example);

    Nation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Nation record, @Param("example") NationExample example);

    int updateByExample(@Param("record") Nation record, @Param("example") NationExample example);

    int updateByPrimaryKeySelective(Nation record);

    int updateByPrimaryKey(Nation record);
}