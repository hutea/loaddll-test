package org.smirkcat.plateocr;

import org.smirkcat.loaddll.JarDllJava;

public class Mser {
		
	// 静态调用只执行一次，加载本地库
		static {
			try {
				JarDllJava.loadLib("Mser", "/dll/",Mser.class);
				System.out.println("加载动态库Mser完成");
			} catch (Exception e) {
				System.err.println("加载动态库Mser失败，错误日志:"+e.getMessage());
			}
		}
		
		/**
		 * 身份证识别号码识别功能
		 * @param image 图片二进制
		 * @return 返回身份证图块二进制
		 */
		public native byte[] detectIdNum(byte[] image);
}
