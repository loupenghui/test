package com.hzsun.demo.testdemo;

import com.alibaba.fastjson.JSON;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.ConverterFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import net.sf.cglib.beans.BeanCopier;
import net.sf.cglib.core.Converter;
import org.apache.commons.beanutils.BeanUtils;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.junit.Test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description:
 * @Author: louph
 * @Date: 2018/12/13 0013
 */
public class VolatileTestTest {

	@Test
	public void test() {

		// 获取当前的日期时间
		LocalDateTime currentTime = LocalDateTime.now();
		System.out.println("当前时间: " + currentTime.toString());
		LocalDate date1 = currentTime.toLocalDate();
		System.out.println("date1: " + date1);
		Month month = currentTime.getMonth();
		int day = currentTime.getDayOfMonth();
		int seconds = currentTime.getSecond();
		System.out.println("月: " + month + ", 日: " + day + ", 秒: " + seconds);
		LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
		System.out.println("date2: " + date2);
		// 12 december 2014
		LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
		System.out.println("date3: " + date3);
		// 22 小时 15 分钟
		LocalTime date4 = LocalTime.of(22, 15);
		System.out.println("date4: " + date4);
		// 解析字符串
		LocalTime date5 = LocalTime.parse("20:15:30");
		System.out.println("date5: " + date5);

		// 获取当前时间日期
		ZonedDateTime date8 = ZonedDateTime.parse("2015-12-03T10:15:30+05:30[Asia/Shanghai]");
		System.out.println("date8: " + date8.toString());

		ZoneId id = ZoneId.of("Europe/Paris");
		System.out.println("ZoneId: " + id);

		ZoneId currentZone = ZoneId.systemDefault();
		System.out.println("当期时区: " + currentZone);

		HashMap map = new HashMap<String, String>();
		map.put("1", "2");
		System.out.println(map.hashCode());
		map.put("2", "3");
		System.out.println(map.hashCode());
		HashMap map2 = (HashMap) map.clone();
		System.out.println(map2.hashCode());
		map2.put("3", "99999999999999999");
		System.out.println(map2.hashCode());
		int[] intarray = new int[]{1, 1, 1};
		System.out.println(intarray.clone());
	}

	@Test
	public void testCglib() {
		Person p1 = PersonFactory.newPrototypeInstance();
		BeanCopier beanCopier = BeanCopier.create(Person.class, Person.class, false);
		Person p2 = new Person();
		beanCopier.copy(p1, p2, null);
		p2.getAddress().setType("Office");
		p2.setAge(18);
		System.out.println("p1=" + p1);
		System.out.println("p2=" + p2);
		System.out.println("p1.jsonstring=" + JSON.toJSONString(p1));
		System.out.println("p2.jsonstring=" + JSON.toJSONString(p2));
	}

	@Test
	public void testCglib2() {
		Person p1 = PersonFactory.newPrototypeInstance();
		BeanCopier beanCopier = BeanCopier.create(Person.class, Person.class, true);
		Person p2 = new Person();
		beanCopier.copy(p1, p2, new Converter() {
			@Override
			public Object convert(Object value, Class target, Object context) {
				if (target.isSynthetic()) {
					BeanCopier.create(target, target, true).copy(value, value, this);
				}
				return value;
			}
		});
		p2.setName("111111111");
		p2.getAddress().setType("Office");
		System.out.println("p1=" + JSON.toJSONString(p1));
		System.out.println("p2=" + JSON.toJSONString(p2));
	}

	@Test
	public void testDozer() {
		Person p1 = PersonFactory.newPrototypeInstance();
		Mapper mapper = new DozerBeanMapper();
		Person p2 = mapper.map(p1, Person.class);
		p2.getAddress().setType("Office");
		System.out.println("p1=" + p1);
		System.out.println("p2=" + p2);
	}

	@Test
	public void testCommonsBeanUtils() {
		Person p1 = PersonFactory.newPrototypeInstance();
		try {
			Person p2 = (Person) BeanUtils.cloneBean(p1);
			System.out.println("p1=" + p1);
			p2.getAddress().setType("Office");
			System.out.println("p2=" + p2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testOrika() {
		MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

		mapperFactory.classMap(Person.class, Person.class)
				.byDefault()
				.register();
		ConverterFactory converterFactory = mapperFactory.getConverterFactory();
		MapperFacade mapper = mapperFactory.getMapperFacade();

		Person p1 = PersonFactory.newPrototypeInstance();
		Person p2 = mapper.map(p1, Person.class);
		System.out.println("p1=" + p1);
		p2.getAddress().setType("Office");
		System.out.println("p2=" + p2);
	}

	static Map<String, String> cacheMap = new ConcurrentHashMap<String, String>(1 << 20);
	static AtomicInteger atomicInteger = new AtomicInteger(10);

	public void testOneThread() {
		long t1 = System.currentTimeMillis();
		for (int j = 0; j < 10_000_000; j++) {
			cacheMap.put(j + "", j + ":" + j);
		}
		System.out.println(System.currentTimeMillis() - t1);
		System.out.println(cacheMap.size());
	}

	public void testMultiThread() {
		final long t1 = System.currentTimeMillis();
		int len = atomicInteger.get();
		for (int i = 0; i < len; i++) {
			final int a = i;
			new Thread(() -> {
				for (int j = 0; j < 1_000_000; j++) {
					cacheMap.put(a + ":" + j, a + ":" + j);
				}
				if (atomicInteger.decrementAndGet() == 0) {
					System.out.println(System.currentTimeMillis() - t1);
					System.out.println(cacheMap.size());
				}
			}).start();

		}
	}

	public static void main(String[] args) {
//		new VolatileTestTest().testOneThread();
		new VolatileTestTest().testMultiThread();
	}

	@Test
	public void base64Test() {
		String url = "https://127.0.0.1/user?name=aaa&psw=123";
		String encode = new String(Base64.getEncoder().encode(url.getBytes()));
		String url_encode = new String(Base64.getUrlEncoder().encode(url.getBytes()));
		System.out.println(encode);
		System.out.println(url_encode);

		System.out.println(new String(Base64.getDecoder().decode(encode)));
		System.out.println(new String(Base64.getUrlDecoder().decode(url_encode)));

	}

	@Test
	public void sriptEngineManagerTest() {
		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
		ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");

		String name = "Runoob";
		Integer result = null;

		try {
			nashorn.eval("print('" + name + "')");
			result = (Integer) nashorn.eval("10 + 2");

		} catch (ScriptException e) {
			System.out.println("执行脚本错误: " + e.getMessage());
		}

		System.out.println(result.toString());
	}
abstract class A{
		public final  static  String a ="";
}
interface B{
	public final  static  String b ="";
}
	@Test
	public void nioTest() throws Exception{String a = A.a;String b = B.b;
		RandomAccessFile aFile = new RandomAccessFile("E:\\桌面/test.txt", "rw");
		FileChannel inChannel = aFile.getChannel();

		ByteBuffer buf = ByteBuffer.allocate(48);

		int bytesRead = inChannel.read(buf);
		while (bytesRead != -1) {

			System.out.println("Read " + bytesRead);
			buf.flip();

			while (buf.hasRemaining()) {
				System.out.print((char) buf.get());
			}

			buf.clear();
			bytesRead = inChannel.read(buf);
		}
		aFile.close();
	}
	@Test
	public void FileChannelTest() throws Exception{
		RandomAccessFile aFile = new RandomAccessFile("E:\\桌面/test.txt", "rw");
		FileChannel inChannel = aFile.getChannel();
		System.out.println(inChannel.size());
		inChannel.truncate(5);
		System.out.println(inChannel.size());
		aFile.close();
	}
	@Test
	public void setSizedefaultBufferTest(){
		long startTime = System.currentTimeMillis();
		// 计数器，用于判断
		int b;
		// 使用数组，一次读多点
		byte[] bytes = new byte[8*1024];
		try {
			// 创建缓冲流，复制电影
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E:\\桌面\\文档\\facefeature\\问题\\问题.zip"));
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:\\桌面/问题.zip"));
			// 读写数据
			while ((b = bis.read(bytes)) != -1) {
				bos.write(bytes, 0 , b);
			}
			// 关闭资源
			bis.close();
			bos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 结束时间
		long endTime = System.currentTimeMillis();
		// 统计用时
		System.out.println("缓冲流（使用数组）复制时间:" + (endTime - startTime) + " 毫秒");
	}
	@Test
	public void defaultBufferTest(){
		// 开始时间
		long startTime = System.currentTimeMillis();
		// 计数器，用于判断
		int b;
		try {
			// 创建缓冲流，复制电影
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E:\\桌面\\文档\\facefeature\\问题\\问题.zip"));
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:\\桌面/问题.zip"));
			// 读写数据
			while ((b = bis.read()) != -1) {
				bos.write(b);
			}
			// 关闭资源
			bis.close();
			bos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 结束时间
		long endTime = System.currentTimeMillis();
		// 统计用时
		System.out.println("缓冲流（默认缓冲区）复制时间:" + (endTime - startTime) + " 毫秒");
	}
	@Test
	public void IdeaTest(){
		String s = "123";
		String str = "abc";
		if (str == null) {
			if (str != null) {
				if (str.length() ==0) {
					boolean b = false;
					if (!b) {

					}

				}
			}
		}
		if (s != null) {
			if (s != null) {
				try {
					ArrayList<String> list = new ArrayList<>();
					for (String s1 : list) {
						
					}
					for (int i = 0; i < list.size(); i++) {
						
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	@Test
	public void ioPathTest() throws Exception{
		/*FileInputStream fileInputStream = new FileInputStream("/test2.txt");//相对路径为当前盘符根目录
		BufferedInputStream bio = new BufferedInputStream(fileInputStream);
		byte[] bytes = new byte[1024];
		int len = -1;
		while ((len=bio.read(bytes))!=-1){
			System.out.println(new String(bytes));
		}*/
		/*Path path = Paths.get(".");
		System.out.println(path.toAbsolutePath());
		File file = new File(".");
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getCanonicalPath());
		file = new File("a/../d");
		System.out.println(file.getAbsolutePath());
		file = new File("D:/a\\");
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getCanonicalPath());*/
		/*String originalPath = "d:\\data\\projects\\a-project\\..\\another-project";
		Path path1 = Paths.get(originalPath);
		System.out.println("path1 = " + path1.toString());
		System.out.println("path1 = " + path1.toAbsolutePath());
		Path path2 = path1.normalize();
		System.out.println("path2 = " + path2);
		System.out.println("path2 = " + path2.toAbsolutePath());*/
//		System.out.println(1 << 2);

	}
}


