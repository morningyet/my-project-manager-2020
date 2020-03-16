package org.morningyet.myvhr2020.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.morningyet.myvhr2020.model.EmployeeTrain;
import org.morningyet.myvhr2020.model.EmployeeTrainExample;

public interface EmployeeTrainMapper {
    long countByExample(EmployeeTrainExample example);

    int deleteByExample(EmployeeTrainExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EmployeeTrain record);

    int insertSelective(EmployeeTrain record);

    List<EmployeeTrain> selectByExample(EmployeeTrainExample example);

    EmployeeTrain selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EmployeeTrain record, @Param("example") EmployeeTrainExample example);

    int updateByExample(@Param("record") EmployeeTrain record, @Param("example") EmployeeTrainExample example);

    int updateByPrimaryKeySelective(EmployeeTrain record);

    int updateByPrimaryKey(EmployeeTrain record);
}