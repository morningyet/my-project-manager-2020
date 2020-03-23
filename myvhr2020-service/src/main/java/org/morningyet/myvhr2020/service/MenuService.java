/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: MenuService
 * Author:   morning
 * Date:     2020-03-16 16:15
 * Description: MenuService
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package org.morningyet.myvhr2020.service;

import org.morningyet.myvhr2020.dao.MenuMapper;
import org.morningyet.myvhr2020.model.Hr;
import org.morningyet.myvhr2020.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author morning
 * @version 1.0.0
 * @desc MenuService
 * @FileName MenuService
 * @create 2020-03-16 16:15
 */
@Service
public class MenuService {

    @Autowired
    MenuMapper menuMapper;


    //@Cacheable
    //需要开启redis
    public List<Menu> getAllMenusWithRole() {
        return menuMapper.getAllMenusWithRole();
    }

    public List<Menu> getMenuById() {
        Integer id = ((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        System.out.println("依据SecurityContextHolder对象查询id="+id+"的用户的角色菜单");
        return menuMapper.getMenuById(id);
    }
}
