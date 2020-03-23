/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: SystemHrController
 * Author:   morning
 * Date:     2020-03-22 23:03
 * Description: 操作员管理
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package org.morningyet.myvhr2020.controller.system;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc
 * 操作员管理
 * @author morning
 * @FileName SystemHrController
 * @create 2020-03-22 23:03
 * @version 1.0.0
 */
@RestController
@RequestMapping("/system/hr")
public class SystemHrController {

    @RequestMapping("/hello")
    public String hello(){
        return "进入/system/hr/hello id=26";
    }
}
