/** 
 *@Project: base-web 
 *@Author: liming
 *@Date: 2017年1月7日 
 * 
 */    
package com.withmes.wxaccounts.config.base.web;

import com.google.common.collect.Maps;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * ClassName: HealthCheckController 
 * 服务监控检测页面
 * @author liming
 * @date 2017年1月7日
 *
 * =================================================================================================
 *     Task ID			  Date			     Author		      Description
 * ----------------+----------------+-------------------+-------------------------------------------
 *
 */
@Controller
@RestController
public class HealthCheckController extends BaseRestfulController{

	
	@RequestMapping("/health")
	@ResponseBody
	public Map<String,Object> health() {
		Map<String,Object> map = Maps.newHashMap();
		map.put("status", "UP");
		return map;
	}
	
	
}
