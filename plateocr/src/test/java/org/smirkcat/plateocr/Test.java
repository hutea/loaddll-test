package org.smirkcat.plateocr;

import org.smirkcat.loaddll.JarDllJava;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 修改为自己的测试路径
		String path =JarDllJava.rootPath(Test.class)+"/jpg/test.jpg";
		byte[] re = Utils.SetImageToByteArray(path);
		String result1 = Ocr.TessOcr(re, false);
		System.out.println("不进行预处理：" + result1);
		String result2 = Ocr.TessOcr(re, true);
		System.out.println("进行预处理：" + result2);

	}

	
}

