package com.hzsun.test.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Configuration
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@Controller
public class TestWebSocketApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestWebSocketApplication.class, args);
	}

	@RequestMapping("/")
	public String index(@RequestParam(value = "loginUsername", required = false) String loginUsername, ModelMap modelMap, HttpServletRequest request, HttpSession session) {
		if (StringUtils.isEmpty(loginUsername)) {
			loginUsername = session.getId();
		}
		modelMap.put("loginUsername", loginUsername);
		return "pages/index";
	}
}
