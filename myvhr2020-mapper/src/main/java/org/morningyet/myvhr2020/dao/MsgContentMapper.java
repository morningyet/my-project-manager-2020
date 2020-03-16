package org.morningyet.myvhr2020.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.morningyet.myvhr2020.model.MsgContent;
import org.morningyet.myvhr2020.model.MsgContentExample;

public interface MsgContentMapper {
    long countByExample(MsgContentExample example);

    int deleteByExample(MsgContentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MsgContent record);

    int insertSelective(MsgContent record);

    List<MsgContent> selectByExample(MsgContentExample example);

    MsgContent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MsgContent record, @Param("example") MsgContentExample example);

    int updateByExample(@Param("record") MsgContent record, @Param("example") MsgContentExample example);

    int updateByPrimaryKeySelective(MsgContent record);

    int updateByPrimaryKey(MsgContent record);
}