package org.morningyet.myvhr2020.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.morningyet.myvhr2020.model.Oplog;
import org.morningyet.myvhr2020.model.OplogExample;

public interface OplogMapper {
    long countByExample(OplogExample example);

    int deleteByExample(OplogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Oplog record);

    int insertSelective(Oplog record);

    List<Oplog> selectByExample(OplogExample example);

    Oplog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Oplog record, @Param("example") OplogExample example);

    int updateByExample(@Param("record") Oplog record, @Param("example") OplogExample example);

    int updateByPrimaryKeySelective(Oplog record);

    int updateByPrimaryKey(Oplog record);
}