/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: CustomUrlDecisionManager
 * Author:   morning
 * Date:     2020-03-16 16:06
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package org.morningyet.myvhr2020.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @desc
 * 登录的角色分析自身所具有的角色
 * @author morning
 * @FileName CustomUrlDecisionManager
 * @create 2020-03-16 16:06
 * @version 1.0.0
 */
@Component
public class CustomUrlDecisionManager implements AccessDecisionManager {

    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {

            for (ConfigAttribute configAttribute : collection) {
                String needRole = configAttribute.getAttribute();
                // 需要的角色仅仅是登录就可以访问的,检测用户的登录状态
                if ("ROLE_LOGIN".equals(needRole)) {
                    if (authentication instanceof AnonymousAuthenticationToken) {
                        throw new AccessDeniedException("尚未登录，请登录!");
                    }else {
                        return;
                    }
                }
                //遍历用户的角色,与需求角色所一一对照,有想等就通过.
                Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
                for (GrantedAuthority authority : authorities) {
                    if (authority.getAuthority().equals(needRole)) {
                        return;
                    }
                }
            }
            throw new AccessDeniedException("权限不足，请联系管理员!");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
