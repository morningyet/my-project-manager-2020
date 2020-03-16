package org.morningyet.myvhr2020.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.morningyet.myvhr2020.model.Hr;
import org.morningyet.myvhr2020.model.HrExample;

public interface HrMapper {

    Hr selectByPrimaryKey(Integer id);

    Hr loadUserByUsername(String username);

}