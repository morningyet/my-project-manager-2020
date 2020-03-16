/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Hello
 * Author:   morning
 * Date:     2020-03-04 9:11
 * Description: 用于测试项目能否正常启动
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package org.morningyet.myvhr2020.controller;


import org.morningyet.myvhr2020.dao.HrMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc
 * 用于测试项目能否正常启动
 * @author morning
 * @FileName Hello
 * @create 2020-03-04 9:11
 * @version 1.0.0
 */
@RestController
public class Hello {

    @Autowired
    HrMapper hrMapper;

    @GetMapping("/hello")
    public String hello(){
        return hrMapper.selectByPrimaryKey(3).toString();
    }
}
