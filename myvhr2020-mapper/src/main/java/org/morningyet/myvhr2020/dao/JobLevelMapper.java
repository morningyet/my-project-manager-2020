package org.morningyet.myvhr2020.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.morningyet.myvhr2020.model.JobLevel;
import org.morningyet.myvhr2020.model.JobLevelExample;

public interface JobLevelMapper {
    long countByExample(JobLevelExample example);

    int deleteByExample(JobLevelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(JobLevel record);

    int insertSelective(JobLevel record);

    List<JobLevel> selectByExample(JobLevelExample example);

    JobLevel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JobLevel record, @Param("example") JobLevelExample example);

    int updateByExample(@Param("record") JobLevel record, @Param("example") JobLevelExample example);

    int updateByPrimaryKeySelective(JobLevel record);

    int updateByPrimaryKey(JobLevel record);
}