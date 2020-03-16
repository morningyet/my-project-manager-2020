package org.morningyet.myvhr2020.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.morningyet.myvhr2020.model.Menu;
import org.morningyet.myvhr2020.model.MenuExample;

@Mapper
public interface MenuMapper {

    List<Menu> getAllMenusWithRole();
}