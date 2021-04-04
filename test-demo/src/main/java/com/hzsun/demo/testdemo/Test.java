package com.hzsun.demo.testdemo;

import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Description:
 * @Author: louph
 * @Date: 2019/2/15 0015
 */
public class Test {
	public static void main(String[] args) throws Exception{
		Thread.sleep(5000);
		int i=0;
		List<Map<String,String>> userInfos  = new ArrayList<Map<String,String>>();
		try {
			while (i<100){
				FileInputStream inFile = new FileInputStream("D:/1.txt");
				InputStreamReader inputStreamReader = new InputStreamReader(inFile,"utf-8");
				BufferedReader bf = new BufferedReader(inputStreamReader);
				String photo = null;
				StringBuilder sb = new StringBuilder();
				while ((photo=bf.readLine())!=null){
					sb.append(photo);
				}
				Map<String,String> map = new HashMap<>();
				map.put("photo",Base64.getEncoder().encodeToString(sb.toString().getBytes()));
				userInfos.add(map);
				i++;
				if(i%10==0){
					System.out.println(i);
				}
				bf.close();
				inFile.close();

			}
			String str = JSON.toJSONString(userInfos);
			System.out.println(str.length());
//			System.out.println(str.length());
//			System.out.println(JSON.toJSONString(userInfos));
			while (true){
				Thread.sleep(50000);
			}

		}catch (Exception e){
			e.printStackTrace();
			System.out.println("=============="+i);
		}

	}

}
