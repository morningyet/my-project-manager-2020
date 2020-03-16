package org.morningyet.myvhr2020.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.morningyet.myvhr2020.model.SysMsg;
import org.morningyet.myvhr2020.model.SysMsgExample;

public interface SysMsgMapper {
    long countByExample(SysMsgExample example);

    int deleteByExample(SysMsgExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysMsg record);

    int insertSelective(SysMsg record);

    List<SysMsg> selectByExample(SysMsgExample example);

    SysMsg selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysMsg record, @Param("example") SysMsgExample example);

    int updateByExample(@Param("record") SysMsg record, @Param("example") SysMsgExample example);

    int updateByPrimaryKeySelective(SysMsg record);

    int updateByPrimaryKey(SysMsg record);
}