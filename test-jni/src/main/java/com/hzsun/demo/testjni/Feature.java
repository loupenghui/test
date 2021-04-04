package com.hzsun.demo.testjni;

import com.sun.jna.Library;
import com.sun.jna.Native;

/**
 * @Description:
 * @Author: louph
 * @Date: 2018/11/27 0027
 */
public class Feature {
	public interface Dll extends Library {
		Dll instance = (Dll) Native.loadLibrary("FaceFeature", Dll.class);
		int getFeatureFromTxt(String txtpath);
		int getFeatureByImgUri(String imgpath);

	}

	public static void main(String[] args) {
		System.out.println("getFeatureFromTxt返回："+Dll.instance.getFeatureFromTxt("D:/photos/filelist.txt"));
	}
}
