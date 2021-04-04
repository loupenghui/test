package com.hzsun.demo.JWT;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description:
 * @Author: louph
 * @Date: 2019/11/30 0030
 */
@Controller
@RequestMapping("/jwt")
public class JTWController{
	@RequestMapping("/test")
	public String testPage(HttpServletResponse rep){
		Cookie cookie = new Cookie("name","test3");
//		cookie.setDomain("127.0.0.1");
		cookie.setValue("test");
		cookie.setMaxAge(100000);
		cookie.setComment("2");
//		cookie.setHttpOnly(true);
		cookie.setPath("/jwt/test");
		rep.addCookie(cookie);
		return "pages/test";
	}
	@RequestMapping("/test2")
	public void testPag2e(HttpServletResponse rep) throws IOException {
		Cookie cookie = new Cookie("name2","test2");
//		cookie.setDomain("127.0.0.2");
		cookie.setValue("test");
		cookie.setMaxAge(100000);
		cookie.setComment("2");
//		cookie.setHttpOnly(true);
		cookie.setPath("/");
		rep.addCookie(cookie);
		rep.sendRedirect("/index.jsp");
	}
}
