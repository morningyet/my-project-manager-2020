/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: EmployeeController
 * Author:   morning
 * Date:     2020-03-22 22:57
 * Description: 员工信息管理
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package org.morningyet.myvhr2020.controller.emp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc
 * 员工信息管理
 * @author morning
 * @FileName EmployeeController
 * @create 2020-03-22 22:57
 * @version 1.0.0
 */
@RestController
@RequestMapping("/employee/basic")
public class EmployeeController {

    @RequestMapping("/hello")
    public String hello(){
        return "进入 /employee/basic/hello 访问"
                +"/employee/basic mid=7,rid=12346";
    }
}
