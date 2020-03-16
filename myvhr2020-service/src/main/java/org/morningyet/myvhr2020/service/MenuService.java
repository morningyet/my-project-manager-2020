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
import org.morningyet.myvhr2020.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @desc
 * MenuService
 * @author morning
 * @FileName MenuService
 * @create 2020-03-16 16:15
 * @version 1.0.0
 */
@Service
public class MenuService {

    @Autowired
    MenuMapper menuMapper;

    public List<Menu> getAllMenusWithRole() {
        return menuMapper.getAllMenusWithRole();
    }
}
