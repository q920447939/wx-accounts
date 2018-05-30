/**
 * @Project:
 * @Author: liming
 * @Date: 2018年05月30日
 * @Copyright: 2018-2028 www.haokukeji.com Inc. All rights reserved.
 */
package com.withmes.wxaccounts.service.wx;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName: CoreService
 *
 * @author liming
 * @Description:
 * @date 2018年05月30日
 */
public interface CoreService {
    public String processRequest(HttpServletRequest request);
}
