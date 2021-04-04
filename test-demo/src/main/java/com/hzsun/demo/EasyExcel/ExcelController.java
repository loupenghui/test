package com.hzsun.demo.EasyExcel;

import com.alibaba.fastjson.JSON;
import com.hzsun.demo.async.AsyncComponent;
import org.springframework.aop.framework.AopContext;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class ExcelController {

	@GetMapping("exportexcel/order")
	public void getexcel(HttpServletResponse response) throws Exception {
		List<OrderExcelBO> list = new ArrayList<OrderExcelBO>();
		for (int i = 0; i < 10; i++) {
			OrderExcelBO orderExcelBO = new OrderExcelBO();
			Method[] methods = orderExcelBO.getClass().getMethods();
			for (Method method : methods) {
				if (method.getName().startsWith("set")) {
					if (method.getParameterTypes()[0] == String.class) {
						method.invoke(orderExcelBO, method.getName() + i);
					} else if (method.getParameterTypes()[0] == BigDecimal.class) {
						method.invoke(orderExcelBO, new BigDecimal("0.005").add(new BigDecimal("" + i)));
					} else if (method.getParameterTypes()[0] == Integer.class) {
						method.invoke(orderExcelBO, new Integer(i));
					}

				}
			}
			list.add(orderExcelBO);

		}
		String filename = "订单记录" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String sheetName = "订单记录";
		ExcelUtil.writeExcel(response, list, filename, sheetName, new OrderExcelBO());
	}

	@PostMapping("/importexcel/order")
	public String import_order(MultipartFile excel) {

		Object objList = ExcelUtil.readExcel(excel, new OrderExcelBO(), 1, 2);

		if (objList == null) {
			return "导入的数据不能为空";
		}

		List<OrderExcelBO> orderList = (List<OrderExcelBO>) objList;

		if (orderList == null || orderList.size() <= 0) {
			return "导入的数据不能为空";
		}

		orderList.forEach(System.out::println);

		return JSON.toJSONString(orderList);
	}

}
