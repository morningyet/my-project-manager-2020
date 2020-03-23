/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: SystemController
 * Author:   morning
 * Date:     2020-03-19 22:46
 * Description: 动态分配可访问的权限菜单
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package org.morningyet.myvhr2020.controller;

import org.morningyet.myvhr2020.model.Menu;
import org.morningyet.myvhr2020.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @desc
 * 动态分配可访问的权限菜单
 * @author morning
 * @FileName SystemController
 * @create 2020-03-19 22:46
 * @version 1.0.0
 */
@RestController
@RequestMapping("/system/config")
public class SystemController {

    @Autowired
    MenuService menuService;

    @GetMapping("/menu")
    public List<Menu> getMenuById(){
        return menuService.getMenuById();
    }


}
