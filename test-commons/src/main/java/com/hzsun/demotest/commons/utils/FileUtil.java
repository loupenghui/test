package com.hzsun.demotest.commons.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FileUtil {

	private FileUtil() {}
	/**临时下载文件夹*/
	public static final String DOWNLOADSFILEPATH = "/tmps/";
	/**模版文件下载文件夹*/
	public static final String TEMPLATEDOWNLOADSFILEPATH = "/static/files/template/";
	/**文件读写的缓冲大小*/
	public static final int BUFFER_SIZE = 16 * 1024;
	/**文件分隔符*/
	public static final String FILE_SEPARATOR = "/";
	/** 保存文件的文件夹名 */
	public static final String PATH = "file";
	
	/**
	 * 创建文件
	 * @param path 路径
	 * @param state 状态 true:文件 false:文件夹
	 */
	public static final void createFile(String path, boolean state) {
		createFile(new File(path), state);
	}
	
	/**
	 * 创建多级目录(把文件路径以分隔符隔开为多个字符串,每个字符串都是一个文件名来判断创建文件)
	 * @param path 路径
	 */
	public static final void makeMoreDir(String path) {
		if (StringUtil.isNotBlank(path)) {
			String file_separator = FILE_SEPARATOR;
			StringTokenizer stringTokenizer = new StringTokenizer(path, file_separator);
			String url = stringTokenizer.nextToken() + file_separator;
			String temp = url;
			while (stringTokenizer.hasMoreTokens()) {
				url = stringTokenizer.nextToken() + file_separator;
				temp += url;
				File file = new File(temp);
				if (!file.exists()) {
					file.mkdir();
				}
			}
		}
	}
	
	/**
	 * 写文件(如果没有则创建目录文件)
	 * @param path 文件全路径(包含文件名)
	 * @param content 内容
	 * @param encoding 编码(默认UTF-8)
	 */
	public static final void writeFile(String path, String content, String encoding) {
		if (StringUtil.isNotBlank(path)) {
			File file = new File(path);
			if (file.exists()) file.delete();
			writeFile(file, content, encoding);
		}
	}
	
	/**
	 * 写文件
	 * @param file 对象
	 * @param content 内容
	 * @param encoding 编码
	 */
	public static final void writeFile(File file, String content, String encoding) {
		if (null != file) {
			if (!file.exists()) {
				createFile(file, true);
			}
			encoding = StringUtil.isBlank(encoding) ? "UTF-8" : encoding;
			FileOutputStream fos = null;
			OutputStreamWriter osw = null;
			BufferedWriter bw = null;
			try {
				fos = new FileOutputStream(file);
				osw = new OutputStreamWriter(fos, encoding);
				bw = new BufferedWriter(osw);
				bw.write(content);
				bw.flush();
			} catch (UnsupportedEncodingException e) {
			} catch (FileNotFoundException e) {
			} catch (IOException e) {
			} finally {
				try {
					if (null != osw) osw.close();
					if (null != fos) fos.close();
					if (null != bw) bw.close();
				} catch (IOException e) {
				}
			}
		}
	}
	
	/**
	 * 拷贝文件
	 * @param source 源文件
	 * @param dest 目标文件
	 */
	public static final void copyFile(File dest, File source) {
		if (null != dest && null != source && source.exists()) {
			if (!dest.exists()) {
				createFile(dest, true);
			}
			InputStream is = null;
			FileInputStream fis = null;
			OutputStream os = null;
			FileOutputStream fos = null;
			try {
				fis = new FileInputStream(source);
				is = new BufferedInputStream(fis, BUFFER_SIZE);
				fos = new FileOutputStream(dest);
				os = new BufferedOutputStream(fos, BUFFER_SIZE);
				byte[] b = new byte[BUFFER_SIZE];
				int len = 0;
				while (0 < (len = is.read(b))) {
					os.write(b, 0, len);
				}
				os.flush();
			} catch (FileNotFoundException e) {
			} catch (IOException e) {
			} finally {
				try {
					if (null != fis) fis.close();
					if (null != is) is.close();
					if (null != fos) fos.close();
					if (null != os) os.close();
				} catch (IOException e) {
				}
			}
		}
	}
	
	/**
	 * 拷贝文件
	 * @param source 源文件
	 * @param dest 目标文件
	 */
	public static final void copyFile(File dest, InputStream is) {
		if (null != dest && null != is) {
			if (!dest.exists()) {
				createFile(dest, true);
			}
			OutputStream os = null;
			FileOutputStream fos = null;
			try {
				fos = new FileOutputStream(dest);
				os = new BufferedOutputStream(fos, BUFFER_SIZE);
				byte[] b = new byte[BUFFER_SIZE];
				int len = 0;
				while (0 < (len = is.read(b))) {
					os.write(b, 0, len);
				}
				os.flush();
			} catch (FileNotFoundException e) {
			} catch (IOException e) {
			} finally {
				try {
					if (null != is) is.close();
					if (null != fos) fos.close();
					if (null != os) os.close();
				} catch (IOException e) {
				}
			}
		}
	}
	
	/**
	 * 拷贝文件
	 * @param source 源文件路径
	 * @param dest 目标文件路径
	 */
	public static final void copyFile(String dest, String source) {
		copyFile(new File(dest), new File(source));
	}
	
	/**
	 * 获取指定路径下文件数量
	 * @param path 路径
	 * @param proFile 是否包含文件夹 true：是 false：否
	 * @param child 是否级联子目录 true：是 false：否
	 * @param encoding 编码(默认为UTF-8)
	 * @return 数量
	 */
	public static final int getFilesCount(String path, boolean proFile, boolean child, String encoding) {
		int count = 0;
		if (StringUtil.isNotBlank(path)) {
			File file = new File(path);
			if (null != file && file.exists()) {
				encoding = StringUtil.isBlank(encoding) ? "UTF-8" : encoding;
				count += getFilesCount(file, proFile);
				if (child) {
					File[] childs = file.listFiles();
					if (null != childs && 0 < childs.length) {
						for (File f : childs) {
							if (f.isDirectory()) {
								count += getFilesCount(f.getPath(), proFile, child, encoding);
							}
						}
					}
				}
			}
		}
		return count;
	}
	
	/**
	 * 获取指定文件下的文件数量
	 * @param file 文件
	 * @param proFile 是否包含文件夹 true：是 false：否
	 * @return 数量
	 */
	public static final int getFilesCount(File file, boolean proFile) {
		int count = 0;
		if (proFile) {
			count = file.list().length;
		} else {
			File[] childs = file.listFiles();
			if (null != childs && 0 < childs.length) {
				for (File f : childs) {
					if (null != f && f.exists() && f.isFile()) {
						count++;
					}
				}
			}
		}
		return count;
	}
	
	/**
	 * 读文件
	 * @param path 路径
	 * @param encoding 编码(默认为UTF-8)
	 * @return 文件内容
	 */
	public static final String readFile(String path, String encoding) {
		String c = "";
		if (StringUtil.isNotBlank(path)) {
			encoding = StringUtil.isBlank(encoding) ? "UTF-8" : encoding;
			File file = new File(path);
			if (file.exists()) c = readFile(file, encoding);
		}
		return c;
	}
	
	/**
	 * 读文件
	 * @param file 文件
	 * @param encoding 编码(默认为UTF-8)
	 * @return 文件内容
	 */
	public static final String readFile(File file, String encoding) {
		String c = "";
		if (null != file && file.exists()) {
			encoding = StringUtil.isBlank(encoding) ? "UTF-8" : encoding;
			FileInputStream fis = null;
			InputStreamReader isr = null;
			BufferedReader br = null;
			try {
				fis = new FileInputStream(file);
				isr = new InputStreamReader(fis, encoding);
				br = new BufferedReader(isr);
				String s = "";
				while ((s = br.readLine()) != null) {
					c += s + "\n";
				}
			} catch (FileNotFoundException e) {
			} catch (UnsupportedEncodingException e) {
			} catch (IOException e) {
			} finally {
				try {
					if (null != fis) fis.close();
					if (null != isr) isr.close();
					if (null != br) br.close();
				} catch (IOException e) {
				}
			}
		}
		return c;
	}
	
	/**
	 * 删除文件
	 * @param path 路径
	 */
	public static final void deleteFile(String path) {
		if (StringUtil.isNotBlank(path)) {
			File file = new File(path); 
			if (file.exists()) {
				deleteFile(file);
			}
		}
	}

	/**
	 * 删除文件
	 * @param file 文件
	 */
	public static final void deleteFile(File file) {
		if (file.exists()) file.delete();
	}
	
	/**
	 * 删除指定路径下所有的文件
	 * (以递归的方式来判断文件下是否有文件夹, 如果有继续往下找, 直到找到文件删除)
	 * @param path 路径
	 * @param state 是否删除自己 true:是 false:否
	 */
	public static final void deleteCascade(String path, boolean state) {
		if (StringUtil.isNotBlank(path)) {
			File file = new File(path);
			if (file.exists() && file.isDirectory()) {
				int count = file.listFiles().length;
				if (0 >= count) {
					file.delete();
				} else {
					File[] childs = file.listFiles();
					for (File f : childs) {
						if (f.isDirectory()) {
							deleteCascade(f.getAbsolutePath(), false);
						}
						f.delete();
					}
				}
				if (state) file.delete();
			}
		}
	}
	
	/**
	 * 取得指定路径下的所有的文件和文件夹
	 * @param path 路径
	 * @return 文件和文件夹集合
	 */
	public static final List<File> getCascade(String path) {
		List<File> list = null;
		if (StringUtil.isNotBlank(path)) {
			File file = new File(path); 
			if (file.exists()) {
				list = getCascade(file);
			}
		}
		return list;
	}

	/**
	 * 取得指定文件下的所有的文件和文件夹
	 * (以递归的方式来判断文件下是否有文件夹, 如果有继续往下找, 直到找到文件为止)
	 * @param file 文件
	 * @return 文件和文件夹集合
	 */
	public static final List<File> getCascade(File file) {
		List<File> list = null;
		if (null != file && file.exists()) {
			list = new ArrayList<File>();
			File[] childs = file.listFiles();
			for (File f : childs) {
				if (f.isFile()) {
					list.add(f);
				}
				if (f.isDirectory()) {
					list.addAll(getCascade(f));
				}
			}
		}
		return list;
	}
	
	/**
	 * 通过文件路径取得文件名
	 * @param path 路径
	 * @return 文件名
	 */
	public static final String getFileName(String path) {
		String name = "";
		if (StringUtil.isNotBlank(path)) {
			File file = new File(path);
			if (file.exists()) {
				name = file.getName();
			}
		}
		return name;
	}
	
	/**
	 * 获得文件大小(单位KB)
	 * @param path 文件路径
	 * @return 文件大小
	 */
//	public static final String getFileSize(String path) {
//		String size = "";
//		if (StringUtil.isNotBlank(path)) {
//			size = getFileSize(new File(path));
//		}
//		return size;
//	}
	
	/**
	 * 获得文件大小(单位KB)
	 * @param path 文件路径
	 * @return 文件大小
	 */
//	public static final String getFileSize(File file) {
//		String size = "";
//		if (null != file && file.exists()) {
//			try {
//				getFileSize(new FileInputStream(file));
//			} catch (FileNotFoundException e) {
//			}
//		}
//		return size;
//	}
	
	/**
	 * 获得文件大小(单位KB)
	 * @param path 文件路径
	 * @return 文件大小
	 */
//	public static final String getFileSize(InputStream inputStream) {
//		String size = "";
//		if (null != inputStream) {
//			try {
//				double resourcesize = (double) ((double) inputStream.available() / 1024);
//				if (resourcesize > 1000) {
//					size = NumberUtil.convertOutput((double) ((double) inputStream.available() / 1024 / 1024), NumberUtil.FORMAT_2) + "MB";
//				} else {
//					size = NumberUtil.convertOutput((double) ((double) inputStream.available() / 1024), NumberUtil.FORMAT_2) + "KB";
//				}
//			} catch (FileNotFoundException e) {
//			} catch (IOException e) {
//			} finally {
//				try {
//					if (null != inputStream) inputStream.close();
//				} catch (IOException e) {
//				}
//			}
//		}
//		return size;
//	}
	
	/**
	 * 创建文件
	 * @param file 文件
	 * @param state 状态 true:文件 false:文件夹
	 */
	public static void createFile(File file, boolean state) {
		if (null == file || !file.exists()) {
			if (null == file.getParentFile() || !file.getParentFile().exists()) {
				createFile(file.getParentFile(), false);
			} else {
				if (state) {
					try {
						file.createNewFile();
						file.setWritable(true, false);
					} catch (IOException e) {
					}
				} else {
					file.mkdir();
				}
			}
		}
	}
}