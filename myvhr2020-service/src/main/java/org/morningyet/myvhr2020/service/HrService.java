/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: HrService
 * Author:   morning
 * Date:     2020-03-04 15:20
 * Description: HrService
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package org.morningyet.myvhr2020.service;

import org.morningyet.myvhr2020.dao.HrMapper;
import org.morningyet.myvhr2020.dao.HrRoleMapper;
import org.morningyet.myvhr2020.model.Hr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @desc
 * HrService
 * @author morning
 * @FileName HrService
 * @create 2020-03-04 15:20
 * @version 1.0.0
 */
@Service
public class HrService implements UserDetailsService {

    @Autowired
    HrMapper hrMapper;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Hr hr = hrMapper.loadUserByUsername(s);
        if (hr == null) {
            throw new UsernameNotFoundException("用户名不存在!");
        }
        //也可以选择在这里为hr注入roles
        return hr;
    }
}
