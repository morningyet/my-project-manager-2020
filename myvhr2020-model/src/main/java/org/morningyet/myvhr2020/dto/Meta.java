/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Meta
 * Author:   morning
 * Date:     2020-03-16 17:03
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package org.morningyet.myvhr2020.dto;

/**
 * @desc
 *
 * @author morning
 * @FileName Meta
 * @create 2020-03-16 17:03
 * @version 1.0.0
 */
public class Meta {
    private Boolean keepAlive;

    private Boolean requireAuth;

    public Boolean getKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(Boolean keepAlive) {
        this.keepAlive = keepAlive;
    }

    public Boolean getRequireAuth() {
        return requireAuth;
    }

    public void setRequireAuth(Boolean requireAuth) {
        this.requireAuth = requireAuth;
    }
}
