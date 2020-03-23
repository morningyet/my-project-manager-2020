/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: SystemBasicController
 * Author:   morning
 * Date:     2020-03-22 23:01
 * Description: 基础信息设置
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package org.morningyet.myvhr2020.controller.system;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc
 * 基础信息设置
 * @author morning
 * @FileName SystemBasicController
 * @create 2020-03-22 23:01
 * @version 1.0.0
 */
@RestController
@RequestMapping("/system/basic")
public class SystemBasicController {

    @RequestMapping("/hello")
    public String hello(){
        return "进入/system/basic/hello id" +
                "= 23  rid = 1 6";
    }
}
