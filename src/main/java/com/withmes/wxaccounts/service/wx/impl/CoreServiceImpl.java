/**
 * @Project:
 * @Author: liming
 * @Date: 2018年05月30日
 * @Copyright: 2018-2028 www.haokukeji.com Inc. All rights reserved.
 */
package com.withmes.wxaccounts.service.wx.impl;

/**
 * ClassName: CoreServiceImpl
 * @Description:
 * @author liming
 * @date 2018年05月30日
 */

import com.withmes.wxaccounts.service.wx.CoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;


/**
 * 核心服务类
 */
@Service("coreService")
public class CoreServiceImpl implements CoreService {

    private static Logger log = LoggerFactory.getLogger(CoreServiceImpl.class);

    /**
     * 处理微信发来的请求（包括事件的推送）
     *
     * @param request
     * @return
     */
    @Override
    public String processRequest(HttpServletRequest request) {
        //暂时对消息不作处理
        return "";
    }
}