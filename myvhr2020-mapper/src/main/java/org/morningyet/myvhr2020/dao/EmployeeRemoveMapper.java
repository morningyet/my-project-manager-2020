package org.morningyet.myvhr2020.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.morningyet.myvhr2020.model.EmployeeRemove;
import org.morningyet.myvhr2020.model.EmployeeRemoveExample;

public interface EmployeeRemoveMapper {
    long countByExample(EmployeeRemoveExample example);

    int deleteByExample(EmployeeRemoveExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EmployeeRemove record);

    int insertSelective(EmployeeRemove record);

    List<EmployeeRemove> selectByExample(EmployeeRemoveExample example);

    EmployeeRemove selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EmployeeRemove record, @Param("example") EmployeeRemoveExample example);

    int updateByExample(@Param("record") EmployeeRemove record, @Param("example") EmployeeRemoveExample example);

    int updateByPrimaryKeySelective(EmployeeRemove record);

    int updateByPrimaryKey(EmployeeRemove record);
}