package org.morningyet.myvhr2020.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.morningyet.myvhr2020.model.HrRole;
import org.morningyet.myvhr2020.model.HrRoleExample;

public interface HrRoleMapper {
    long countByExample(HrRoleExample example);

    int deleteByExample(HrRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HrRole record);

    int insertSelective(HrRole record);

    List<HrRole> selectByExample(HrRoleExample example);

    HrRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HrRole record, @Param("example") HrRoleExample example);

    int updateByExample(@Param("record") HrRole record, @Param("example") HrRoleExample example);

    int updateByPrimaryKeySelective(HrRole record);

    int updateByPrimaryKey(HrRole record);
}