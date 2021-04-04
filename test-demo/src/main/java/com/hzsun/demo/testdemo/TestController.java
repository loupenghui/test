package com.hzsun.demo.testdemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * @Description:
 * @Author: louph
 * @Date: 2019/5/23 0023
 */
@RestController
public class TestController {
	//给定范围获得随机颜色
	static Color getRandColor(int fc, int bc) {
		Random random = new Random();
		if (fc > 255) fc = 255;
		if (bc > 255) bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}
	@RequestMapping("/verifycode")
	public void verifyCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		int width = 120;// 定义图片的width
		int height = 40;// 定义图片的height
		BufferedImage bfi = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		Graphics g = bfi.getGraphics();
		g.fillRect(0, 0, width, height);
		char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
		char[] char_arr=new char[4];
		StringBuffer sb = new StringBuffer(); //保存字符串
		int index;
		Random r = new Random();
		char[] chars1= "abcdefghijklmnopqrstuvwxyz".toCharArray();
		char[] chars2= "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		char[] chars3 = "0123456789".toCharArray();
		index = (int)Math.floor(r.nextDouble() * chars1.length);
		char_arr[0]= chars1[index];
		index= (int)Math.floor(r.nextDouble() * chars2.length);
		char_arr[1]= chars2[index];
		index =(int)Math.floor(r.nextDouble() * chars3.length);
		char_arr[2]= chars3[index];
		index =(int)Math.floor(r.nextDouble() * chars.length);
		char_arr[3]= chars[index];
		for(int i = 0; i < 4; i++){
			index = (int)Math.floor(r.nextDouble() * 4);
			char temp = char_arr[index];
			char_arr[index] = char_arr[i];
			char_arr[i]= temp;
		}
		for(int i=0; i<4; i++){
			g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
			Font font = new Font("宋体", 30, 36);
			g.setFont(font);
			g.drawString(char_arr[i]+"", (i*30)+5, 34);
		}
		// 添加噪点
		int area = (int) (0.02 * width * height);
		for(int i=0; i<area; ++i){
			int x = (int)(r.nextDouble() * width);
			int y = (int)(r.nextDouble() * height);
			bfi.setRGB(x, y, (int)(r.nextDouble() * 255));
		}
	        /*//设置验证码中的干扰线
	        for (int i = 0; i < 6; i++) {
	              //随机获取干扰线的起点和终点
	              int xstart = (int)(r.nextDouble() * 80);
	              int ystart = (int)(r.nextDouble() * 25);
	              int xend = (int)(r.nextDouble() * 80);
	              int yend = (int)(r.nextDouble() * 25);
	              g.setColor(interLine(1, 255));
	              g.drawLine(xstart, ystart, xend, yend);
	        }*/
		sb.append(char_arr);
		OutputStream os = response.getOutputStream();
		ImageIO.write(bfi, "JPG", os);  //写到输出流
		// 以下关闭输入流！
		try {
			os.flush();
			os.close();
		}catch (Exception e){

		}
	}

	@RequestMapping("/verifycode2")
	public void verifyCode2(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		//实例生成验证码对象
		int width = 120;// 定义图片的width
		int height = 40;// 定义图片的height
		int xx = 30;
		int fontHeight = 36;
		int codeY = 34;
		String code = "1Dda";
		// 定义图像buffer
		BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics gd = buffImg.getGraphics();
		// 将图像填充为白色
		gd.setColor(Color.WHITE);
		gd.fillRect(0, 0, width, height);

		// 创建字体，字体的大小应该根据图片的高度来定。
		Font font = new Font("Arial", Font.CENTER_BASELINE | Font.ITALIC, fontHeight);
		// 设置字体。
		gd.setFont(font);
		// 创建一个随机数生成器类
		Random random = new Random();
		int codeCount = code.length();
		for (int i = 0; i < codeCount; i++) {
			// 用随机产生的颜色将验证码绘制到图像中。
			gd.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
			gd.drawString(String.valueOf(code.charAt(i)), (i*xx)+5, codeY);
		}
		// 添加噪点
		int area = (int) (0.02 * width * height);
		for(int i=0; i<area; ++i){
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			buffImg.setRGB(x, y, random.nextInt(255));
		}
		for (int i = 0; i < 168; i++) {
			//随机获取干扰线的起点和终点
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			gd.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
			gd.drawLine(x, y, x + xl, y + yl);
		}
		OutputStream os = response.getOutputStream();
		ImageIO.write(buffImg, "JPEG", os);
		// 以下关闭输入流！
		try {
			os.flush();
			os.close();
		}catch (Exception e){

		}
	}
}
