/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: LoginController
 * Author:   morning
 * Date:     2020-03-05 14:50
 * Description: 登陆跳转的接口
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package org.morningyet.myvhr2020.controller;

import org.morningyet.myvhr2020.dto.RespBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc
 * 登陆跳转的接口
 * @author morning
 * @FileName LoginController
 * @create 2020-03-05 14:50
 * @version 1.0.0
 */
@RestController
public class LoginController {
    @GetMapping("/login")
    public RespBean login(){
        return RespBean.error("尚未登录,请登录");
    }
}
