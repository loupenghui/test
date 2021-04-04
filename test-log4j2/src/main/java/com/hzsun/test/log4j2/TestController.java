package com.hzsun.test.log4j2;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: louph
 * @Date: 2019/12/27 0027
 */
@RestController
public class TestController {
	Logger logger = LoggerFactory.getLogger(TestController.class);
	@RequestMapping(value = "/print")
	public Map print2() throws Exception {
		Map map = new HashMap();
		map.put("name", "帅哥");
		if(logger.isDebugEnabled()){
			logger.debug("debug{}",JSON.toJSONString(map));
		}
		logger.info("info{}",JSON.toJSONString(map));
		logger.error("error{}",JSON.toJSONString(map));
		logger.warn("warn{}",JSON.toJSONString(map));
		return map;
	}
}
